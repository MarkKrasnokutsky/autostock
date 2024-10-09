package com.mark.autostock.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String position;
    private Integer salary;
}
