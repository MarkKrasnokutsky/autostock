package com.mark.autostock.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "оборудование", schema = "autostock")
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Оборудования", nullable = false)
    private Long id;

    @Column(name = "Название", nullable = false, length = 64)
    private String name;

    @Column(name = "Стоимость", nullable = false)
    @Min(value = 1, message = "Стоимость должна быть больше 0")
    private Integer price;

    @Column(name = "Кол-во", nullable = false)
    private Integer count;
}
