package com.mark.autostock.domain.dto.response;

import com.mark.autostock.domain.entity.PaymentEntity;
import com.mark.autostock.domain.entity.SellEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long paymentId;
    private SellEntity sell;
    private LocalDate paymentDate;
    private Integer paymentCost;
    private String paymentMethod;
}
