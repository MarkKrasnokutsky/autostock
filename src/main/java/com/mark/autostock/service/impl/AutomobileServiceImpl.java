package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.AutomobileRequest;
import com.mark.autostock.domain.dto.response.AutomobileResponse;
import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.repository.AutomobileRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomobileServiceImpl implements CrudServiceI<AutomobileRequest, AutomobileResponse, Long> {
    private final AutomobileRepository automobileRepository;

    public List<AutomobileResponse> getAll() {
        List<AutomobileResponse> autoResList = new ArrayList<>();
        List<AutomobileEntity> entities = automobileRepository.findAll();
        for (AutomobileEntity entity : entities){
            AutomobileResponse autoRes = new AutomobileResponse();
            autoRes.setId(entity.getId());
            autoRes.setType(entity.getType());
            autoRes.setFirm(entity.getFirm());
            autoRes.setModel(entity.getModel());
            autoRes.setColor(entity.getColor());
            autoRes.setYear(entity.getYear());
            autoRes.setVolEngine(entity.getVolEngine());
            autoRes.setPower(entity.getPower());
            autoRes.setMileage(entity.getMileage());
            autoRes.setCost(entity.getCost());
            autoRes.setStatus(entity.getStatus());
            autoResList.add(autoRes);
        }
        return autoResList;
    }

    public AutomobileResponse getById(Long id) {
        AutomobileEntity entity = automobileRepository.findById(id).orElse(null);
        AutomobileResponse autoRes = new AutomobileResponse();
        autoRes.setId(entity.getId());
        autoRes.setType(entity.getType());
        autoRes.setFirm(entity.getFirm());
        autoRes.setModel(entity.getModel());
        autoRes.setColor(entity.getColor());
        autoRes.setYear(entity.getYear());
        autoRes.setVolEngine(entity.getVolEngine());
        autoRes.setPower(entity.getPower());
        autoRes.setMileage(entity.getMileage());
        autoRes.setCost(entity.getCost());
        autoRes.setStatus(entity.getStatus());
        return autoRes;
    }

    public AutomobileResponse add(AutomobileRequest automobile) {
        AutomobileEntity entity = new AutomobileEntity();
        entity.setType(automobile.getType());
        entity.setFirm(automobile.getFirm());
        entity.setModel(automobile.getModel());
        entity.setColor(automobile.getColor());
        entity.setYear(automobile.getYear());
        entity.setVolEngine(automobile.getVolEngine());
        entity.setPower(automobile.getPower());
        entity.setMileage(automobile.getMileage());
        entity.setCost(automobile.getCost());
        entity.setStatus(automobile.getStatus());
        automobileRepository.save(entity);
        AutomobileResponse autoRes = new AutomobileResponse();
        autoRes.setId(entity.getId());
        autoRes.setType(entity.getType());
        autoRes.setFirm(entity.getFirm());
        autoRes.setModel(entity.getModel());
        autoRes.setColor(entity.getColor());
        autoRes.setYear(entity.getYear());
        autoRes.setVolEngine(entity.getVolEngine());
        autoRes.setPower(entity.getPower());
        autoRes.setMileage(entity.getMileage());
        autoRes.setCost(entity.getCost());
        autoRes.setStatus(entity.getStatus());
        return autoRes;
    }

    public void delete(Long id) {
        AutomobileEntity entity = automobileRepository.findById(id).get();
        automobileRepository.delete(entity);
    }

    public AutomobileResponse change(Long id, AutomobileRequest auto) {
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
        automobileRepository.save(entity);
        AutomobileResponse autoRes = new AutomobileResponse();
        autoRes.setId(entity.getId());
        autoRes.setType(entity.getType());
        autoRes.setFirm(entity.getFirm());
        autoRes.setModel(entity.getModel());
        autoRes.setColor(entity.getColor());
        autoRes.setYear(entity.getYear());
        autoRes.setVolEngine(entity.getVolEngine());
        autoRes.setPower(entity.getPower());
        autoRes.setMileage(entity.getMileage());
        autoRes.setCost(entity.getCost());
        autoRes.setStatus(entity.getStatus());
        return autoRes;
    }
}
