package com.example.demo.entity;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImgurUploader {
    // Imgur API endpoint for image upload
    private static final String IMGUR_API_URL = "https://api.imgur.com/3/image";
    private static final String IMGUR_CLIENT_ID = "258d1858df56d23"; // Replace with your Imgur client ID

    public static String uploadImageToImgur(File imageFile) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(IMGUR_API_URL);

        // Set Imgur client ID in request header
        request.setHeader("Authorization", "Client_Id" + IMGUR_CLIENT_ID);

        try {
            // Read the image file into a byte array
            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());

            // Encode the image as a Base64 string
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            // Create JSON payload for Imgur upload
            JSONObject json = new JSONObject();
            json.put("image", base64Image);

            // Set the payload as a request entity
            StringEntity entity = new StringEntity(json.toString());
            request.setEntity(entity);

            // Execute the request
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity responseEntity = response.getEntity();

            if (response.getStatusLine().getStatusCode() == 200) {
                String responseString = EntityUtils.toString(responseEntity);
                JSONObject jsonResponse = new JSONObject(responseString);
                if (jsonResponse.has("data")) {
                    JSONObject data = jsonResponse.getJSONObject("data");
                    if (data.has("link")) {
                        // Return the URL of the uploaded image
                        return data.getString("link");
                    }
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
