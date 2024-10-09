package com.mark.autostock.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
@Table(name = "клиент", schema = "autostock")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код_Клиента")
    private Integer id;

    @Column(name = "ФИО_клиента", nullable = false, length = 256)
    private String fullName;

    @Column(name = "Номер_Телефона", nullable = false, unique = true, length = 12)
    private String phoneNumber;

    @Column(name = "Дата_Рождения", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<SellEntity> sells; // Связь с продажами
}
