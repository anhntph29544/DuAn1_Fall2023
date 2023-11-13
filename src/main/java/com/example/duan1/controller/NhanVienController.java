package com.example.duan1.controller;


import com.example.duan1.entity.NhanVien;
import com.example.duan1.service.ChucVuService;
import com.example.duan1.service.NhanVienService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    //API UP Ảnh lên Imngur
    private final String IMGUR_API_URL = "https://api.imgur.com/3/image";
    private final String CLIENT_ID = "d0a17fce113a6ae";
    private final String BEAR_TOKEN = "51fef63c53144a38215324961f0b5eb06b54b71b";

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num", defaultValue = "0") Integer num) {
        Integer sizePage = 5;
        Pageable pageable = PageRequest.of(num, sizePage);
        Page<NhanVien> list = nhanVienService.getAll(pageable);
        model.addAttribute("list", list.getContent());
        model.addAttribute("total", list.getTotalPages());
        model.addAttribute("num", num);
        model.addAttribute("sizePage", sizePage);
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("chucVu", chucVuService.getAll());
        return "/nhanvien/hienThi";
    }

    @GetMapping("/detail/{id}")
    public String showFormForUpdate(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienService.detail(id).get();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("chucVu", chucVuService.getAll());
        return "/nhanvien/formUpdateNV";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien) {
        nhanVienService.delete(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTrangThai(0);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("chucVu", chucVuService.getAll());

        List<String> cities = getGhnCities();
        List<String> districts = getGhnDistricts("202");
        List<String> wards = getGhnWards("1442");

        model.addAttribute("cities", cities);
        model.addAttribute("districts", districts);
        model.addAttribute("wards", wards);

        return "/nhanvien/formAddNV";
    }

    private List<String> getGhnCities() {
        try {
            HttpResponse<String> response = Unirest.get("https://online-gateway.ghn.vn/shiip/public-api/master-data/province")
                    .header("Content-Type", "application/json")
                    .header("Token", "6cbda0e4-7e4c-11ee-a59f-a260851ba65c")
                    .asString();

            if (response.getStatus() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode root = objectMapper.readTree(response.getBody());

                if (root.has("data")) {
                    JsonNode dataNode = root.get("data");
                    List<String> cities = new ArrayList<>();

                    for (JsonNode cityNode : dataNode) {
                        if (cityNode.has("ProvinceName")) {
                            cities.add(cityNode.get("ProvinceName").asText());
                        }
                    }
                    return cities;
                }
            }
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<String> getGhnDistricts(String provinceId) {
        try {
            HttpResponse<String> response = Unirest.get("https://online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id=" + provinceId)
                    .header("Content-Type", "application/json")
                    .header("Token", "6cbda0e4-7e4c-11ee-a59f-a260851ba65c")
                    .asString();

            if (response.getStatus() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode root = objectMapper.readTree(response.getBody());

                if (root.has("data")) {
                    JsonNode dataNode = root.get("data");
                    List<String> districts = new ArrayList<>();

                    for (JsonNode districtNode : dataNode) {
                        if (districtNode.has("DistrictName")) {
                            districts.add(districtNode.get("DistrictName").asText());
                        }
                    }
                    return districts;
                }
            }
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private List<String> getGhnWards(String districtId) {
        try {
            String url = "https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=" + districtId;
            HttpResponse<String> response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Token", "6cbda0e4-7e4c-11ee-a59f-a260851ba65c")
                    .asString();

            if (response.getStatus() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode root = objectMapper.readTree(response.getBody());

                if (root.has("data")) {
                    JsonNode dataNode = root.get("data");
                    List<String> wards = new ArrayList<>();

                    for (JsonNode wardNode : dataNode) {
                        if (wardNode.has("WardName")) {
                            wards.add(wardNode.get("WardName").asText());
                        }
                    }
                    return wards;
                }
            }
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
                       BindingResult bindingResult, Model model,
                       @RequestParam("imageFile") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVuService.getAll());
            return "/nhanvien/formAddNV";
        }
        if (!file.isEmpty()) {
            try {
                byte[] imageBytes = file.getBytes();
                String imgurUrl = uploadImage(imageBytes);

                if (imgurUrl != null) {
                    nhanVien.setImage(imgurUrl);
                } else {
                    System.out.println("Lỗi khi tải ảnh lên Imgur");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String randomPassword = generateRandomPassword();

        nhanVien.setMatKhau(randomPassword);
        nhanVienService.save(nhanVien);
        sendAccountInfoEmail(nhanVien.getEmail(), randomPassword);
        return "redirect:/nhan-vien/hien-thi";
    }

    // Phương thức này để gửi email với thông tin tài khoản mới
    private void sendAccountInfoEmail(String toEmail, String password) {
        final String username = "hieundph29149@fpt.edu.vn";
        final String emailPassword = "zyjwdrhgsgflbnwd";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, emailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Thông tin tài khoản mới");
            String emailContent = "Tài khoản của bạn là: " + toEmail + "\nMật khẩu của bạn là: " + password;
            message.setText(emailContent);

            Transport.send(message);

            System.out.println("Email đã được gửi thành công!");
            System.out.println("email:" +toEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRandomPassword() {
        int passwordLength = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
                         BindingResult bindingResult, Model model,
                         @RequestParam("imageFile") MultipartFile file,
                         @PathVariable("id") UUID idNhanVien) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVuService.getAll());
            return "/nhanvien/formUpdateNV";
        }
        if (nhanVien.getIdNhanVien() == null) {
            return "error-page";
        }

        NhanVien currentNhanVien = nhanVienService.detail(nhanVien.getIdNhanVien()).orElse(null);

        if (currentNhanVien != null) {
            if (!file.isEmpty()) {
                try {
                    byte[] imageBytes = file.getBytes();
                    String imgurUrl = uploadImage(imageBytes);

                    if (imgurUrl != null) {
                        nhanVien.setImage(imgurUrl);
                    } else {
                        System.out.println("Lỗi khi tải ảnh lên Imgur");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                nhanVien.setImage(currentNhanVien.getImage());
            }

            boolean updated = nhanVienService.update(nhanVien, idNhanVien);
            if (updated) {
                return "redirect:/nhan-vien/hien-thi";
            } else {
                return "error-page";
            }
        } else {
            return "error-page";
        }
    }

    @GetMapping("/image/{id}")
    public void showImage(@PathVariable("id") UUID id, HttpServletResponse response) {
        NhanVien nhanVien = nhanVienService.detail(id).get();
        if (nhanVien != null && nhanVien.getImage() != null) {
            try {
                HttpResponse<InputStream> imgurResponse = Unirest.get(nhanVien.getImage()).header("accept", "image/*").asBinary();
                InputStream inputStream = imgurResponse.getBody();
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
            } catch (IOException | UnirestException e) {
                e.printStackTrace();
            }
        }
    }

    public String uploadImage(byte[] imageBytes) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + CLIENT_ID);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("image", new ByteArrayResource(imageBytes));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(IMGUR_API_URL, requestEntity, Map.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map data = response.getBody();
                return data.get("data").toString().substring(data.get("data").toString().indexOf("link")).replace("}","").replace("link=","");
            } else {
                throw new RuntimeException("Image upload to Imgur failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
