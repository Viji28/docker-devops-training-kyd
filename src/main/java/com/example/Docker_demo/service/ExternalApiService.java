package com.example.Docker_demo.service;


import com.example.Docker_demo.dto.ApiObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    private final String BASE_URL = "https://api.restful-api.dev/objects";

    private RestTemplate restTemplate = new RestTemplate();

    // ✅ GET all objects
    public ResponseEntity<Object> getAllObjects() {
        return restTemplate.getForEntity(BASE_URL, Object.class);
    }

    // ✅ POST a new object
    public ResponseEntity<ApiObject> createObject(ApiObject apiObject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ApiObject> request = new HttpEntity<>(apiObject, headers);

        return restTemplate.postForEntity(BASE_URL, request, ApiObject.class);
    }

    // ✅ DELETE object by ID
    public ResponseEntity<String> deleteObject(String id) {
        restTemplate.delete(BASE_URL + "/" + id);
        return ResponseEntity.ok("Deleted ID: " + id);
    }
}

