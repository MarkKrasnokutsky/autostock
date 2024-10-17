package com.mark.autostock.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "сотрудник", schema = "autostock")
public class EmployerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код_Сотрудника")
    private Long id;

    @Column(name = "ФИО_Сотрудника", nullable = false, length = 256)
    private String fullName;

    @Column(name = "Номер_Телефона", nullable = false, unique = true, length = 12)
    private String phoneNumber;

    @Column(name = "Должность", nullable = false, length = 45)
    private String position;

    @Column(name = "Зарплата", nullable = false)
    @Min(value = 1, message = "Зарплата должна быть больше нуля")
    private Integer salary;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<SellEntity> sells; // Связь с продажами

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<TestDriveEntity> testDrives; // Связь с продажами

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Пользователя")
    @JsonBackReference
    private UserEntity user; // Связь с пользователем

}
