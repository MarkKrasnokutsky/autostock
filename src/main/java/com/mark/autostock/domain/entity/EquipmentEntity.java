package com.mark.autostock.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EquipmentRelEntity> equipmentRelEntitySet; // Связь с оснащением
}
