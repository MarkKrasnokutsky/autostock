package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.PaymentEntity;
import com.mark.autostock.util.annotation.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    @Query(value = "SELECT * FROM autostock.`платёж`", entity = PaymentEntity.class)
    List<PaymentEntity> findAll();

    @Query(value = "INSERT INTO autostock.`платёж` " +
            "(`Номер_Продажи`, `Дата_Платежа`, `Сумма_Платежа`, `Способ_Оплаты`) " +
            "VALUES (?2, ?3, ?4, ?5)",
            entity = PaymentEntity.class)
    PaymentEntity save(PaymentEntity entity);

    @Query(value = "UPDATE autostock.`платёж` " +
            "SET " +
            "`Номер_Продажи` = ?2, `Дата_Платежа` = ?3, `Сумма_Платежа` = ?4, `Способ_Оплаты` = ?5" +
            "WHERE `Номер_Платежа` = ?1",
            entity = PaymentEntity.class)
    Optional<PaymentEntity> save(Optional<PaymentEntity> entity);

    @Query(value = "SELECT * FROM autostock.`платёж` WHERE `Номер_Платежа` = ?1", entity = PaymentEntity.class)
    Optional<PaymentEntity> findById(Long id);

    @Query(value = "DELETE FROM autostock.`платёж` " +
            "WHERE " +
            "`Номер_Платежа` = ?1, `Номер_Продажи` = ?2, `Дата_Платежа` = ?3, `Сумма_Платежа` = ?4, `Способ_Оплаты` = ?5",
            entity = PaymentEntity.class)
    void delete(PaymentEntity entity);
}
