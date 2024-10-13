package com.mark.autostock.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.domain.entity.ClientEntity;
import com.mark.autostock.domain.entity.EmployerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDriveResponse {
    private Long id;
    private ClientEntity client;
    private EmployerEntity employer;
    private AutomobileEntity auto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
}
