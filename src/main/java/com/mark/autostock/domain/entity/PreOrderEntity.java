package com.mark.autostock.domain.entity;

import jakarta.persistence.*;
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
@Table(name = "предзаказ", schema = "autostock")
public class PreOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Номер_Предзаказа", nullable = false)
    private Long id;

    @Column(name = "Тип_Кузова", nullable = false)
    private String type;

    @Column(name = "Марка", nullable = false)
    private String firm;

    @Column(name = "Модель", nullable = false)
    private String model;

    @Column(name = "Цвет", nullable = false)
    private String color;

    @Column(name = "Пробег", nullable = false)
    private Integer mileage;

    @Column(name = "Страна_Экспорта", nullable = false)
    private String exportCountry;

    @ManyToOne
    @JoinColumn(name = "Код_Клиента", nullable = false)
    private ClientEntity client;

    @Column(name = "Дата_Привоза", nullable = false)
    private LocalDate date;
}
