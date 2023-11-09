package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.NhanVienService;
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
        return "hienThiNV";
    }

    @GetMapping("/detail")
    public String showFormForUpdate(@RequestParam("IdNhanVien") UUID id, Model model) {
        NhanVien nhanVien = nhanVienService.detail(id).get();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("chucVu", chucVuService.getAll());
        return "formUpdateNV";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("IdNhanVien") NhanVien nhanVien) {
        nhanVienService.delete(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        NhanVien nhanVien = new NhanVien();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("chucVu", chucVuService.getAll());

        List<String> cities = getGhnCities();
        List<String> districts = getGhnDistricts("202");
        List<String> wards = getGhnWards("1442"); // Không có thông tin quận/huyện ban đầu, bạn có thể cung cấp districtId tùy ý

        model.addAttribute("cities", cities);
        model.addAttribute("districts", districts);
        model.addAttribute("wards", wards);

        System.out.println("Danh sách thành phố từ API GHN: " + cities);

        System.out.println("Danh sách huyện từ API GHN: " + districts);

        System.out.println("Danh sách xã từ API GHN: " + wards);

        return "formAddNV";
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
    public String save(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien, BindingResult bindingResult, Model model, @RequestParam("imageFile") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVuService.getAll());
            return "formAddNV";
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

        // Tạo mật khẩu ngẫu nhiên
        String randomPassword = generateRandomPassword();

        // Lưu mật khẩu ngẫu nhiên vào đối tượng nhanVien
        nhanVien.setMatKhau(randomPassword);
        nhanVienService.save(nhanVien);
        sendAccountInfoEmail(nhanVien.getEmail(), randomPassword);
        return "redirect:/nhan-vien/hien-thi";
    }

    // Phương thức này để gửi email với thông tin tài khoản mới
    private void sendAccountInfoEmail(String toEmail, String password) {
        final String username = "hieundph29149@fpt.edu.vn"; //  địa chỉ email của bạn
        final String emailPassword = "zyjwdrhgsgflbnwd"; //  mật khẩu email của bạn

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); //Bật xác thực SMTP (Simple Mail Transfer Protocol) để đảm bảo bạn đã đăng nhập trước khi gửi email.
        props.put("mail.smtp.starttls.enable", "true");//Bật TLS (Transport Layer Security) để mã hóa kết nối gửi email.
        props.put("mail.smtp.host", "smtp.gmail.com"); //Cài đặt máy chủ SMTP của Gmail.
        props.put("mail.smtp.port", "587"); // Cài đặt cổng của máy chủ SMTP Gmail.

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { //Tạo một phiên (session) dựa trên các cài đặt và thông tin xác thực.
                // Bạn sử dụng Authenticator để cung cấp địa chỉ email và mật khẩu để xác thực với máy chủ email.
                return new PasswordAuthentication(username, emailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Thiết lập địa chỉ người gửi email.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // Thiết lập địa chỉ email của người nhận.
            message.setSubject("Thông tin tài khoản mới"); //Thiết lập tiêu đề của email.
            String emailContent = "Tài khoản của bạn là: " + toEmail + "\nMật khẩu của bạn là: " + password;
            message.setText(emailContent); // Thiết lập nội dung email, bao gồm mật khẩu tài khoản mới.

            Transport.send(message); //Gửi email thông qua máy chủ SMTP đã được cấu hình và sử dụng thông tin xác thực.

            System.out.println("Email đã được gửi thành công!");
            System.out.println("email:" +toEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Phương thức này để tạo mật khẩu ngẫu nhiên
    private String generateRandomPassword() {
        // Tạo một mật khẩu ngẫu nhiên, ví dụ: 8 ký tự
        int passwordLength = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        //Trong mỗi lần lặp, hàm sẽ chọn ngẫu nhiên một ký tự từ chuỗi characters.
        // Điều này được thực hiện bằng cách tạo một số ngẫu nhiên index từ 0 đến độ dài của chuỗi characters,
        // sau đó lấy ký tự tại vị trí index và thêm vào mật khẩu.
        return password.toString();
    }


//    @PostMapping("/update")
//    public String update(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
//                         BindingResult bindingResult, Model model,
//                         @RequestParam("imageFile") MultipartFile file) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("chucVu", chucVuService.getAll());
//            return "formUpdateNV";
//        }
//        if (nhanVien.getIdNhanVien() == null) {
//            // Xử lý lỗi - Chưa có định danh của nhân viên
//            return "error-page";
//        }
//        if (!file.isEmpty()) {
//            try {
//                byte[] imageBytes = file.getBytes();
//                String imgurUrl = uploadImage(imageBytes);
//
//                if (imgurUrl != null) {
//                    nhanVien.setImage(imgurUrl);
//                } else {
//                    System.out.println("Lỗi khi tải ảnh lên Imgur");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        boolean updated = nhanVienService.update(nhanVien, nhanVien.getIdNhanVien());
//        if (updated) {
//            return "redirect:/nhan-vien/hien-thi";
//        } else {
//            // Xử lý lỗi cập nhật
//            return "error-page";
//        }
//    }

    @PostMapping("/update")
    public String update(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
                         BindingResult bindingResult, Model model,
                         @RequestParam("imageFile") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVuService.getAll());
            return "formUpdateNV";
        }
        if (nhanVien.getIdNhanVien() == null) {
            // Xử lý lỗi - Chưa có định danh của nhân viên
            return "error-page";
        }

        // Lấy thông tin nhân viên hiện tại từ cơ sở dữ liệu
        NhanVien currentNhanVien = nhanVienService.detail(nhanVien.getIdNhanVien()).orElse(null);

        if (currentNhanVien != null) {
            // Nếu có tệp ảnh được tải lên, cập nhật đường dẫn ảnh mới
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
                // Nếu không có tệp ảnh mới được tải lên, giữ nguyên đường dẫn ảnh cũ
                nhanVien.setImage(currentNhanVien.getImage());
            }

            boolean updated = nhanVienService.update(nhanVien, nhanVien.getIdNhanVien());
            if (updated) {
                return "redirect:/nhan-vien/hien-thi";
            } else {
                // Xử lý lỗi cập nhật
                return "error-page";
            }
        } else {
            // Xử lý lỗi - Nhân viên không tồn tại
            return "error-page";
        }
    }

    @GetMapping("/image/{id}")
    public void showImage(@PathVariable("id") UUID id, HttpServletResponse response) {
        NhanVien nhanVien = nhanVienService.detail(id).get();
        if (nhanVien != null && nhanVien.getImage() != null) {
            try {
                // Truy cập hình ảnh từ URL Imgur và hiển thị
                // Sử dụng thư viện Unirest để tải hình ảnh từ URL được lưu trong nhanVien.getImage().
                // Kết quả là một HttpResponse chứa dữ liệu hình ảnh ở định dạng InputStream.
                HttpResponse<InputStream> imgurResponse = Unirest.get(nhanVien.getImage()).header("accept", "image/*").asBinary();
                InputStream inputStream = imgurResponse.getBody(); //Lấy InputStream từ phản hồi của Imgur.
                IOUtils.copy(inputStream, response.getOutputStream()); //Sao chép nội dung từ InputStream vào luồng đầu ra của phản hồi HTTP để hiển thị hình ảnh.
                response.flushBuffer(); //Xác nhận việc sao chép và gửi dữ liệu đã hoàn thành.
            } catch (IOException | UnirestException e) {
                e.printStackTrace();
            }
        }
    }

    public String uploadImage(byte[] imageBytes) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + CLIENT_ID); // Đặt tiêu đề "Authorization" với giá trị "Client-ID" và một giá trị CLIENT_ID.
        headers.setContentType(MediaType.MULTIPART_FORM_DATA); //Đặt kiểu phương thức là MULTIPART_FORM_DATA để chỉ định rằng yêu cầu sẽ chứa dữ liệu đa phần.

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>(); //Tạo một MultiValueMap để lưu trữ dữ liệu gửi đi trong yêu cầu.
        // Dữ liệu sẽ được truyền dưới dạng đối tượng ByteArrayResource.

        body.add("image", new ByteArrayResource(imageBytes)); // Thêm dữ liệu hình ảnh vào body với tên là "image"
        // và giá trị là ByteArrayResource của hình ảnh từ mảng imageBytes.

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers); // Tạo một HttpEntity chứa dữ liệu yêu cầu và các tiêu đề.

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(IMGUR_API_URL, requestEntity, Map.class); //Sử dụng RestTemplate để gửi yêu cầu POST chứa hình ảnh lên Imgur API.
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
