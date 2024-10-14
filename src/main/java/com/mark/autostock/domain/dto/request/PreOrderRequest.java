package com.mark.autostock.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mark.autostock.domain.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreOrderRequest {
    private String type;
    private String firm;
    private String model;
    private String color;
    private Integer mileage;
    private String exportCountry;
    private Long clientId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
}
