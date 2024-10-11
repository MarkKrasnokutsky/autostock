package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.EquipmentRequest;
import com.mark.autostock.domain.dto.response.EquipmentResponse;
import com.mark.autostock.domain.entity.EquipmentEntity;
import com.mark.autostock.domain.transfer.impl.EquipmentTransferImpl;
import com.mark.autostock.repository.EquipmentRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements CrudServiceI<EquipmentRequest, EquipmentResponse, Long> {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentTransferImpl transfer;

    @Override
    public List<EquipmentResponse> getAll() {
        List<EquipmentResponse> equipmentResList = new ArrayList<>();
        List<EquipmentEntity> entities = equipmentRepository.findAll();
        for (EquipmentEntity entity : entities){
            equipmentResList.add(transfer.entityToResponse(entity));
        }
        return equipmentResList;
    }

    @Override
    public EquipmentResponse getById(Long id) {
        EquipmentEntity entity = equipmentRepository.findById(id).orElse(null);
        return transfer.entityToResponse(entity);
    }

    @Override
    public EquipmentResponse add(EquipmentRequest req) {
        EquipmentEntity entity = transfer.requestToEntity(req);
        equipmentRepository.save(entity);
        return transfer.entityToResponse(entity);
    }

    @Override
    public void delete(Long id) {
        EquipmentEntity entity = equipmentRepository.findById(id).get();
        equipmentRepository.delete(entity);
    }

    @Override
    public EquipmentResponse change(Long id, EquipmentRequest req) {
        EquipmentEntity entity = equipmentRepository.findById(id).get();
        entity.setName(req.getName());
        entity.setPrice(req.getPrice());
        entity.setCount(req.getCount());
        equipmentRepository.save(entity);
        return transfer.entityToResponse(entity);
    }
}
