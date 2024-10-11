package com.mark.autostock.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "оснащение", schema = "autostock")
public class EquipmentRelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Оснащения", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Id_Автомобиля", nullable = false)
    private AutomobileEntity automobile; // Ссылка на сущность автомобиля

    @ManyToOne
    @JoinColumn(name = "Id_Оборудования", nullable = false)
    private EquipmentEntity equipment; // Ссылка на сущность оборудования

}
