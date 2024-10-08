package com.mark.autostock.service;

import com.mark.autostock.entity.AutomobileEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class AutomobileService {
    @PersistenceContext
    private EntityManager entityManager;

    public AutomobileEntity create(AutomobileEntity entity) {
        // Получаем значения из объекта entity
        String type = entity.getType();
        String firm = entity.getFirm();
        String model = entity.getModel();
        String color = entity.getColor();
        Integer year = entity.getYear();
        Double volEngine = entity.getVolEngine();
        Integer power = entity.getPower();
        Integer mileage = entity.getMileage();
        Integer cost = entity.getCost();
        String status = entity.getStatus();

        // Выполняем запрос с параметрами
        int rowsAffected = entityManager.createNativeQuery(getQuery())
                .setParameter(1, type)
                .setParameter(2, firm)
                .setParameter(3, model)
                .setParameter(4, color)
                .setParameter(5, year)
                .setParameter(6, volEngine)
                .setParameter(7, power)
                .setParameter(8, mileage)
                .setParameter(9, cost)
                .setParameter(10, status)
                .executeUpdate();

        // Если запись вставлена (rowsAffected > 0)
        if (rowsAffected > 0) {
            // Возвращаем объект entity, возможно с id, если он сгенерирован
            return entity;
        } else {
            // Возвращаем null или бросаем исключение
            return null;
            // throw new PersistenceException("Ошибка при сохранении автомобильной записи");
        }
    }

    private String getQuery() {
        return "INSERT INTO autostock.`автомобиль` " +
                "(`Тип_Кузова`, `Марка`, `Модель`, `Цвет`, `Год_Выпуска`, `Объём_Двигателя`, `Лошадиные_Силы`, `Пробег`, `Стоимость`, `Статус`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
