package com.example.Docker_demo.controller;




import com.example.Docker_demo.dto.ApiObject;
import com.example.Docker_demo.service.ExternalApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external")
public class ApiController {

    private final ExternalApiService apiService;

    public ApiController(ExternalApiService apiService) {
        this.apiService = apiService;
    }

    // ✅ GET → https://api.restful-api.dev/objects
    @GetMapping("/objects")
    public ResponseEntity<Object> getAllObjects() {
        return apiService.getAllObjects();
    }

    // ✅ POST → https://api.restful-api.dev/objects
    @PostMapping("/objects")
    public ResponseEntity<ApiObject> createObject(@RequestBody ApiObject apiObject) {
        return apiService.createObject(apiObject);
    }

    // ✅ DELETE → https://api.restful-api.dev/objects/{id}
    @DeleteMapping("/objects/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable String id) {
        return apiService.deleteObject(id);
    }
}

