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
@Table(name = "тест_драйв", schema = "autostock")
public class TestDriveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Номер_Тест_Драйва", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Код_Клиента", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "Код_Сотрудника", nullable = false)
    private EmployerEntity employee;

    @ManyToOne
    @JoinColumn(name = "Id_Автомобиля", nullable = false)
    private AutomobileEntity auto;

    @Column(name = "Дата_Проведения", nullable = false)
    private LocalDate date;
}
