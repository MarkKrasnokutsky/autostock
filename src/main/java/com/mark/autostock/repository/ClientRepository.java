package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.ClientEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`клиент`", entity = ClientEntity.class)
    List<ClientEntity> findAll();

    @Query(value = "INSERT INTO autostock.`клиент` " +
            "(`ФИО_клиента`, `Номер_Телефона`, `Дата_Рождения`) " +
            "VALUES (?2, ?3, ?4)",
            entity = ClientEntity.class)
    ClientEntity save(ClientEntity entity);

    @Query(value = "UPDATE autostock.`клиент` " +
            "SET " +
            "`ФИО_клиента` = ?2, `Номер_Телефона` = ?3, `Дата_Рождения` = ?4 " +
            "WHERE `Код_Клиента` = ?1",
            entity = ClientEntity.class)
    Optional<ClientEntity> save(Optional<ClientEntity> entity);

    @Query(value = "SELECT * FROM autostock.`клиент` WHERE `Код_Клиента` = ?1", entity = ClientEntity.class)
    Optional<ClientEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`клиент` " +
            "WHERE " +
            "`Код_Клиента` = ?1 `ФИО_клиента` = ?2, `Номер_Телефона` = ?3, `Дата_Рождения` = ?4",
            entity = ClientEntity.class)
    void delete(ClientEntity entity);
}
