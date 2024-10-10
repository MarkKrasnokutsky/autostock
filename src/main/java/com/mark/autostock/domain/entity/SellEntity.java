package com.mark.autostock.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "продажа", schema = "autostock")
public class SellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Номер_Продажи", nullable = false)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_Автомобиля", nullable = false)
    private AutomobileEntity automobile;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Код_Клиента", nullable = false)
    private ClientEntity client;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Код_Сотрудника", nullable = false)
    private EmployerEntity employer;

    @Column(name = "Дата_Продажи", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate sellDate;

    @Column(name = "Итоговая_Стоимость", nullable = false)
    @Min(value = 1, message = "Итоговая стоимость должна быть больше нуля")
    private Integer totalCost;

    @Column(name = "Статус_Оплаты", nullable = false, length = 45)
    private String status;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "sell")
    private List<PaymentEntity> payments;
}
