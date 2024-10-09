package com.mark.autostock.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
