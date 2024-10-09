package com.mark.autostock.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutomobileRequest {
    private String type;
    private String firm;
    private String model;
    private String color;
    private Integer year;
    private Double volEngine;
    private Integer power;
    private Integer mileage;
    private Integer cost;
    private String status;
}
