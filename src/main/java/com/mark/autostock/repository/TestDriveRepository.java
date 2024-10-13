package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.TestDriveEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestDriveRepository extends JpaRepository<TestDriveEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`тест_драйв`", entity = TestDriveEntity.class)
    List<TestDriveEntity> findAll();

    @Query(value = "INSERT INTO autostock.`тест_драйв` " +
            "(`Код_Клиента`, `Код_Сотрудника`, `Id_Автомобиля`, `Дата_Проведение`) " +
            "VALUES (?2, ?3, ?4, ?5)",
            entity = TestDriveEntity.class)
    TestDriveEntity save(TestDriveEntity entity);

    @Query(value = "UPDATE autostock.`тест_драйв` " +
            "SET " +
            "`Код_Клиента` = ?2, `Код_Сотрудника` = ?3, `Id_Автомобиля` = ?4, `Дата_Проведение` = ?5" +
            "WHERE `Номер_Тест_Драйва` = ?1",
            entity = TestDriveEntity.class)
    Optional<TestDriveEntity> save(Optional<TestDriveEntity> entity);

    @Query(value = "SELECT * FROM autostock.`тест_драйв` WHERE `Номер_Тест_Драйва` = ?1", entity = TestDriveEntity.class)
    Optional<TestDriveEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`тест_драйв` " +
            "WHERE " +
            "`Номер_Тест_Драйва` = ?1, `Код_Клиента` = ?2, `Код_Сотрудника` = ?3, `Id_Автомобиля` = ?4, `Дата_Проведения` = ?5",
            entity = TestDriveEntity.class)
    void delete(TestDriveEntity entity);
}
