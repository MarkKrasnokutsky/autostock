package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.SellEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellRepository extends JpaRepository<SellEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`продажа`", entity = SellEntity.class)
    List<SellEntity> findAll();

    @Query(value = "INSERT INTO autostock.`продажа` " +
            "(`Id_Автомобиля`, `Код_Клиента`, `Код_Сотрудника`, `Дата_Продажи`, `Итоговая_Стоимость`, `Статус_оплаты`) " +
            "VALUES (?2, ?3, ?4, ?5, ?6, ?7)",
            entity = SellEntity.class)
    SellEntity save(SellEntity entity);

    @Query(value = "UPDATE autostock.`продажа` " +
            "SET " +
            "`Id_Автомобиля` = ?2, `Код_Клиента` = ?3, `Код_Сотрудника` = ?4, `Дата_Продажи` = ?5, `Итоговая_Стоимость` = ?6, `Статус_оплаты` = ?7" +
            "WHERE `Номер_Продажи` = ?1",
            entity = SellEntity.class)
    Optional<SellEntity> save(Optional<SellEntity> entity);

    @Query(value = "SELECT * FROM autostock.`продажа` WHERE `Номер_Продажи` = ?1", entity = SellEntity.class)
    Optional<SellEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`продажа` " +
            "WHERE " +
            "`Номер_Продажи` = ?1, `Id_Автомобиля` = ?2, `Код_Клиента` = ?3, `Код_Сотрудника` = ?4, `Дата_Продажи` = ?5, `Итоговая_Стоимость` = ?6, `Статус_оплаты` = ?7",
            entity = SellEntity.class)
    void delete(SellEntity entity);
}
