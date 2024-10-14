package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.PreOrderRequest;
import com.mark.autostock.domain.dto.response.AutomobileResponse;
import com.mark.autostock.domain.dto.response.PreOrderResponse;
import com.mark.autostock.domain.dto.response.TestDriveResponse;
import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.domain.entity.PreOrderEntity;
import com.mark.autostock.domain.entity.TestDriveEntity;
import com.mark.autostock.repository.ClientRepository;
import com.mark.autostock.repository.PreOrderRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreOrderServiceImpl implements CrudServiceI<PreOrderRequest, PreOrderResponse, Long> {
    private final PreOrderRepository preOrderRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<PreOrderResponse> getAll() {
        List<PreOrderResponse> preOrderResList = new ArrayList<>();
        List<PreOrderEntity> entities = preOrderRepository.findAll();
        for (PreOrderEntity entity : entities){
            PreOrderResponse res = PreOrderResponse
                    .builder()
                    .id(entity.getId())
                    .type(entity.getType())
                    .firm(entity.getFirm())
                    .model(entity.getModel())
                    .color(entity.getColor())
                    .mileage(entity.getMileage())
                    .exportCountry(entity.getExportCountry())
                    .client(entity.getClient())
                    .date(entity.getDate())
                    .build();
            preOrderResList.add(res);
        }
        return preOrderResList;
    }

    @Override
    public PreOrderResponse getById(Long id) {
        PreOrderEntity entity = preOrderRepository.findById(id).orElse(null);
        return PreOrderResponse
                .builder()
                .id(entity.getId())
                .type(entity.getType())
                .firm(entity.getFirm())
                .model(entity.getModel())
                .color(entity.getColor())
                .mileage(entity.getMileage())
                .exportCountry(entity.getExportCountry())
                .client(entity.getClient())
                .date(entity.getDate())
                .build();
    }

    @Override
    public PreOrderResponse add(PreOrderRequest req) {
        PreOrderEntity entity = new PreOrderEntity();
        entity.setType(req.getType());
        entity.setFirm(req.getFirm());
        entity.setModel(req.getModel());
        entity.setColor(req.getColor());
        entity.setMileage(req.getMileage());
        entity.setExportCountry(req.getExportCountry());
        entity.setClient(clientRepository.findById(req.getClientId()).get());
        entity.setDate(req.getDate());
        preOrderRepository.save(entity);
        return PreOrderResponse
                .builder()
                .id(entity.getId())
                .type(entity.getType())
                .firm(entity.getFirm())
                .model(entity.getModel())
                .color(entity.getColor())
                .mileage(entity.getMileage())
                .exportCountry(entity.getExportCountry())
                .client(entity.getClient())
                .date(entity.getDate())
                .build();
    }

    @Override
    public void delete(Long id) {
        PreOrderEntity entity = preOrderRepository.findById(id).get();
        preOrderRepository.delete(entity);
    }

    @Override
    public PreOrderResponse change(Long id, PreOrderRequest req) {
        PreOrderEntity entity = preOrderRepository.findById(id).get();
        entity.setType(req.getType());
        entity.setFirm(req.getFirm());
        entity.setModel(req.getModel());
        entity.setColor(req.getColor());
        entity.setMileage(req.getMileage());
        entity.setExportCountry(req.getExportCountry());
        entity.setClient(clientRepository.findById(req.getClientId()).get());
        entity.setDate(req.getDate());
        preOrderRepository.save(entity);
        return PreOrderResponse
                .builder()
                .id(entity.getId())
                .type(entity.getType())
                .firm(entity.getFirm())
                .model(entity.getModel())
                .color(entity.getColor())
                .mileage(entity.getMileage())
                .exportCountry(entity.getExportCountry())
                .client(entity.getClient())
                .date(entity.getDate())
                .build();
    }
}
