package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.EquipmentEntity;
import com.mark.autostock.domain.entity.EquipmentRelEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRelRepository extends JpaRepository<EquipmentRelEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`оснащение`", entity = EquipmentRelEntity.class)
    List<EquipmentRelEntity> findAll();

    @Query(value = "INSERT INTO autostock.`оснащение` " +
            "(`Id_Автомобиля`, `Id_Оборудования`) " +
            "VALUES (?2, ?3)",
            entity = EquipmentRelEntity.class)
    EquipmentRelEntity save(EquipmentRelEntity entity);

    @Query(value = "UPDATE autostock.`оснащение` " +
            "SET " +
            "`Id_Автомобиля` = ?2, `Id_Оборудования` = ?3 " +
            "WHERE `Id_Оснащения` = ?1",
            entity = EquipmentRelEntity.class)
    Optional<EquipmentRelEntity> save(Optional<EquipmentRelEntity> entity);

    @Query(value = "SELECT * FROM autostock.`оснащение` WHERE `Id_Оснащения` = ?1", entity = EquipmentRelEntity.class)
    Optional<EquipmentRelEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`оснащение` " +
            "WHERE " +
            "`Id_Оснащения` = ?1 `Id_Автомобиля` = ?2, `Id_Оборудования` = ?3",
            entity = EquipmentRelEntity.class)
    void delete(EquipmentRelEntity entity);
}
