package com.mark.autostock.repository;

import com.mark.autostock.entity.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer> {

    @Override
    @Query(value = "SELECT * FROM autostock.`автомобиль`", nativeQuery = true)
    List<AutomobileEntity> findAll();

}
