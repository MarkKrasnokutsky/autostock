package com.mark.autostock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

//    @Column(name = "reset_code", nullable = true, length = 6)
//    @Schema(description = "Код для сброса пароля пользователя")
//    private String resetCode;



    @Override
    public String toString() {
        return "Id:" + id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }
}
