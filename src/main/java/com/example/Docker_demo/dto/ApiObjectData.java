package com.example.Docker_demo.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiObjectData {
    private int year;
    private double price;

    @JsonProperty("CPU model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;
}

