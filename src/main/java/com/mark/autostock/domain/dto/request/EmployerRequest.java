package com.mark.autostock.domain.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRequest {
    private String fullName;
    private String phoneNumber;
    private String position;
    private Integer salary;
}
