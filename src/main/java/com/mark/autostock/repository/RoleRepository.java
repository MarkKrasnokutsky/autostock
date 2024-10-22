package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.RoleEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query(value = "SELECT * FROM autostock.role", entity = RoleEntity.class)
    List<RoleEntity> findAll();

    @Query(value = "INSERT INTO autostock.role " +
            "(name) " +
            "VALUES (?2)",
            entity = RoleEntity.class)
    RoleEntity save(RoleEntity entity);

    @Query(value = "UPDATE autostock.role " +
            "SET " +
            "name = ?2 " +
            "WHERE id = ?1",
            entity = RoleEntity.class)
    Optional<RoleEntity> save(Optional<RoleEntity> entity);

    @Query(value = "SELECT * FROM autostock.role WHERE id = ?1", entity = RoleEntity.class)
    Optional<RoleEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.role " +
            "WHERE " +
            "id = ?1, name = ?2",
            entity = RoleEntity.class)
    void delete(RoleEntity entity);
}
