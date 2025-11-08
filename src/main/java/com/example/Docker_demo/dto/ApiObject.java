package com.example.Docker_demo.dto;



import lombok.Data;

@Data
public class ApiObject {
    private String id;
    private String name;
    private ApiObjectData data;
}

