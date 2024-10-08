package com.mark.autostock.repository;

import com.mark.autostock.entity.AutomobileEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer> {

    @Query(value = "SELECT * FROM autostock.`автомобиль`", entity = AutomobileEntity.class)
    List<AutomobileEntity> findAll();

    @Query(value = "INSERT INTO autostock.`автомобиль` " +
            "(`Тип_Кузова`, `Марка`, `Модель`, `Цвет`, `Год_Выпуска`, `Объём_Двигателя`, `Лошадиные_Силы`, `Пробег`, `Стоимость`, `Статус`) " +
            "VALUES (?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)",
            entity = AutomobileEntity.class)
    AutomobileEntity save(AutomobileEntity entity);

    @Query(value = "UPDATE autostock.автомобиль " +
            "SET " +
            "`Тип_Кузова` = ?2, `Марка` = ?3, `Модель` = ?4, `Цвет` = ?5, `Год_Выпуска` = ?6, `Объём_Двигателя` = ?7, `Лошадиные_Силы` = ?8, `Пробег` = ?9, `Стоимость` = ?10, `Статус` = ?11 " +
            "WHERE `id_Автомобиля` = ?1",
    entity = AutomobileEntity.class)
    Optional<AutomobileEntity> save(Optional<AutomobileEntity> entity);

    @Query(value = "SELECT * FROM autostock.`автомобиль` WHERE `id_Автомобиля` = ?1", entity = AutomobileEntity.class)
    Optional<AutomobileEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`автомобиль` " +
            "WHERE " +
            "`id_Автомобиля` = ?1 `Тип_Кузова` = ?2, `Марка` = ?3, `Модель` = ?4, `Цвет` = ?5, `Год_Выпуска` = ?6, `Объём_Двигателя` = ?7, `Лошадиные_Силы` = ?8, `Пробег` = ?9, `Стоимость` = ?10, `Статус` = ?11",
            entity = AutomobileEntity.class)
    void delete(AutomobileEntity entity);
}
