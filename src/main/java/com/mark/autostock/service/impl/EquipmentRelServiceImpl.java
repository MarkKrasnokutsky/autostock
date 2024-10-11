package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.EquipmentRelRequest;
import com.mark.autostock.domain.dto.response.EquipmentRelResponse;
import com.mark.autostock.domain.entity.EquipmentRelEntity;
import com.mark.autostock.repository.AutomobileRepository;
import com.mark.autostock.repository.EquipmentRelRepository;
import com.mark.autostock.repository.EquipmentRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentRelServiceImpl implements CrudServiceI<EquipmentRelRequest, EquipmentRelResponse, Long> {
    private final EquipmentRelRepository equipmentRelRepository;
    private final EquipmentRepository equipmentRepository;
    private final AutomobileRepository automobileRepository;

    @Override
    public List<EquipmentRelResponse> getAll() {
        List<EquipmentRelResponse> equipmentRelResponses = new ArrayList<>();
        List<EquipmentRelEntity> entities = equipmentRelRepository.findAll();
        for (EquipmentRelEntity entity : entities){
            EquipmentRelResponse res = EquipmentRelResponse
                    .builder()
                    .id(entity.getId())
                    .automobile(entity.getAutomobile())
                    .equipment(entity.getEquipment())
                    .build();
            equipmentRelResponses.add(res);
        }
        return equipmentRelResponses;
    }

    @Override
    public EquipmentRelResponse getById(Long id) {
        EquipmentRelEntity entity = equipmentRelRepository.findById(id).orElse(null);
        return EquipmentRelResponse
                .builder()
                .id(entity.getId())
                .automobile(entity.getAutomobile())
                .equipment(entity.getEquipment())
                .build();
    }

    @Override
    public EquipmentRelResponse add(EquipmentRelRequest req) {
        EquipmentRelEntity entity = new EquipmentRelEntity();
        entity.setEquipment(equipmentRepository.findById(req.getEquipmentId()).get());
        entity.setAutomobile(automobileRepository.findById(req.getAutomobileId()).get());
        equipmentRelRepository.save(entity);
        return EquipmentRelResponse
                .builder()
                .id(entity.getId())
                .automobile(entity.getAutomobile())
                .equipment(entity.getEquipment())
                .build();
    }

    @Override
    public void delete(Long id) {
        EquipmentRelEntity entity = equipmentRelRepository.findById(id).get();
        equipmentRelRepository.delete(entity);
    }

    @Override
    public EquipmentRelResponse change(Long id, EquipmentRelRequest req) {
        EquipmentRelEntity entity = equipmentRelRepository.findById(id).get();
        entity.setEquipment(equipmentRepository.findById(req.getEquipmentId()).get());
        entity.setAutomobile(automobileRepository.findById(req.getAutomobileId()).get());
        equipmentRelRepository.save(entity);
        return EquipmentRelResponse
                .builder()
                .id(entity.getId())
                .automobile(entity.getAutomobile())
                .equipment(entity.getEquipment())
                .build();
    }
}
