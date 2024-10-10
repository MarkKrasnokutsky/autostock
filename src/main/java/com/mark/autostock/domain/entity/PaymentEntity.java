package com.mark.autostock.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "платёж", schema = "autostock")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Номер_Платежа", nullable = false)
    private Long paymentNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Номер_Продажи", nullable = false)
    private SellEntity sell;

    @Column(name = "Дата_Платежа", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "Сумма_Платежа", nullable = false)
    @Min(value = 1, message = "Сумма платежа должна быть больше нуля")
    private Integer paymentAmount;

    @Column(name = "Способ_Оплаты", nullable = false, length = 45)
    private String paymentMethod;
}
