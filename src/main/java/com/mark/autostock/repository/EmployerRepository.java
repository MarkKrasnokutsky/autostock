package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.EmployerEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`сотрудник`", entity = EmployerEntity.class)
    List<EmployerEntity> findAll();

    @Query(value = "INSERT INTO autostock.`сотрудник` " +
            "(`ФИО_Сотрудника`, `Номер_Телефона`, `Должность`, `Зарплата`) " +
            "VALUES (?2, ?3, ?4, ?5)",
            entity = EmployerEntity.class)
    EmployerEntity save(EmployerEntity entity);

    @Query(value = "UPDATE autostock.`сотрудник` " +
            "SET " +
            "`ФИО_Сотрудника` = ?2, `Номер_Телефона` = ?3, `Должность` = ?4, `Зарплата` = ?5 " +
            "WHERE `Код_Сотрудника` = ?1",
            entity = EmployerEntity.class)
    Optional<EmployerEntity> save(Optional<EmployerEntity> entity);

    @Query(value = "SELECT * FROM autostock.`сотрудник` WHERE `Код_Сотрудника` = ?1", entity = EmployerEntity.class)
    Optional<EmployerEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`сотрудник` " +
            "WHERE " +
            "`Код_Сотрудника` = ?1 `ФИО_Сотрудника` = ?2, `Номер_Телефона` = ?3, `Должность` = ?4, `Зарплата` = ?5",
            entity = EmployerEntity.class)
    void delete(EmployerEntity entity);
}
