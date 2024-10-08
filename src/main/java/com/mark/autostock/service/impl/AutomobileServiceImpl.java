package com.mark.autostock.service.impl;

import com.mark.autostock.entity.AutomobileEntity;
import com.mark.autostock.repository.AutomobileRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomobileServiceImpl implements CrudServiceI<AutomobileEntity, Long> {
    private final AutomobileRepository automobileRepository;

    public List<AutomobileEntity> getAll() {
        return automobileRepository.findAll();
    }

    public AutomobileEntity getById(Long id) {
        return automobileRepository.findById(id).orElse(null);
    }

    public AutomobileEntity add(AutomobileEntity automobile) {
        return automobileRepository.save(automobile);
    }

    public void delete(Long id) {
        AutomobileEntity entity = automobileRepository.findById(id).get();
        automobileRepository.delete(entity);
    }

    public AutomobileEntity change(Long id, AutomobileEntity auto) {
        AutomobileEntity entity = automobileRepository.findById(id).get();
        entity.setType(auto.getType());
        entity.setFirm(auto.getFirm());
        entity.setModel(auto.getModel());
        entity.setColor(auto.getColor());
        entity.setYear(auto.getYear());
        entity.setVolEngine(auto.getVolEngine());
        entity.setPower(auto.getPower());
        entity.setMileage(auto.getMileage());
        entity.setCost(auto.getCost());
        entity.setStatus(auto.getStatus());
        return automobileRepository.save(entity);
    }
}
