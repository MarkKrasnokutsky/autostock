package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.EquipmentEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`оборудование`", entity = EquipmentEntity.class)
    List<EquipmentEntity> findAll();

    @Query(value = "INSERT INTO autostock.`оборудование` " +
            "(`Название`, `Стоимость`, `Кол-во`) " +
            "VALUES (?2, ?3, ?4)",
            entity = EquipmentEntity.class)
    EquipmentEntity save(EquipmentEntity entity);

    @Query(value = "UPDATE autostock.`оборудование` " +
            "SET " +
            "`Название` = ?2, `Стоимость` = ?3, `Кол-во` = ?4 " +
            "WHERE `Id_Оборудования` = ?1",
            entity = EquipmentEntity.class)
    Optional<EquipmentEntity> save(Optional<EquipmentEntity> entity);

    @Query(value = "SELECT * FROM autostock.`оборудование` WHERE `Id_Оборудования` = ?1", entity = EquipmentEntity.class)
    Optional<EquipmentEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`оборудование` " +
            "WHERE " +
            "`Id_Оборудования` = ?1 `Название` = ?2, `Стоимость` = ?3, `Кол-во` = ?4",
            entity = EquipmentEntity.class)
    void delete(EquipmentEntity entity);
}
