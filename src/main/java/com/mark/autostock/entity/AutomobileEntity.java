package com.mark.autostock.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "автомобиль", schema = "autostock")
public class AutomobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Автомобиля", nullable = false)
    private Integer id;

    @Column(name = "Тип_Кузова", nullable = false, length = 32)
    private String type;

    @Column(name = "Марка", nullable = false, length = 128)
    private String firm;

    @Column(name = "Модель", nullable = false, length = 128)
    private String model;

    @Column(name = "Цвет", nullable = false, length = 32)
    private String color;

    @Column(name = "Год_Выпуска", nullable = false)
    @Min(1951) // Минимальный год выпуска
    private Integer year;

    @Column(name = "Объём_Двигателя", nullable = false)
    @DecimalMin("0.1") // Минимальный объем двигателя
    private Double volEngine;

    @Column(name = "Лошадиные_Силы", nullable = false)
    @Min(1) // Минимальное количество лошадиных сил
    private Integer power;

    @Column(name = "Пробег", nullable = false)
    @Min(1) // Минимальный пробег
    private Integer mileage;

    @Column(name = "Стоимость", nullable = false)
    @Min(1) // Минимальная стоимость
    private Integer cost;

    @Column(name = "Статус", nullable = false, length = 32)
    private String status;
}
