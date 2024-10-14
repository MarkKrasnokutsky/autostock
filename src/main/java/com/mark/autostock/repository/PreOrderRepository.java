package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.PreOrderEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreOrderRepository extends JpaRepository<PreOrderEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`предзаказ`", entity = PreOrderEntity.class)
    List<PreOrderEntity> findAll();

    @Query(value = "INSERT INTO autostock.`предзаказ` " +
            "(`Тип_Кузова`, `Марка`, `Модель`, `Цвет`, `Пробег`, `Страна_Экспорта`, `Код_Клиента`, `Дата_Привоза`) " +
            "VALUES (?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)",
            entity = PreOrderEntity.class)
    PreOrderEntity save(PreOrderEntity entity);

    @Query(value = "UPDATE autostock.`предзаказ` " +
            "SET " +
            "`Тип_Кузова` = ?2, `Марка` = ?3, `Модель` = ?4, `Цвет` = ?5, `Пробег` = ?6, `Страна_Экспорта` = ?7, `Код_Клиента` = ?8, `Дата_Привоза` = ?9" +
            "WHERE `Номер_Предзаказа` = ?1",
            entity = PreOrderEntity.class)
    Optional<PreOrderEntity> save(Optional<PreOrderEntity> entity);

    @Query(value = "SELECT * FROM autostock.`предзаказ` WHERE `Номер_Предзаказа` = ?1", entity = PreOrderEntity.class)
    Optional<PreOrderEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`предзаказ` " +
            "WHERE " +
            "`Номер_Предзаказа` = ?1 `Тип_Кузова` = ?2, `Марка` = ?3, `Модель` = ?4, `Цвет` = ?5, `Пробег` = ?6, `Страна_Экспорта` = ?7, `Код_Клиента` = ?8, `Дата_Привоза` = ?9",
            entity = PreOrderEntity.class)
    void delete(PreOrderEntity entity);
}
