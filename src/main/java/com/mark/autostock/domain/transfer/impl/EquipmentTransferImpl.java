package com.mark.autostock.domain.transfer.impl;

import com.mark.autostock.domain.dto.request.EquipmentRequest;
import com.mark.autostock.domain.dto.response.EquipmentResponse;
import com.mark.autostock.domain.entity.EquipmentEntity;
import com.mark.autostock.domain.transfer.TransferI;
import org.springframework.stereotype.Service;

@Service
public class EquipmentTransferImpl implements TransferI<EquipmentRequest, EquipmentResponse, EquipmentEntity> {
    @Override
    public EquipmentResponse requestToResponse(EquipmentRequest equipmentRequest) {
        return null;
    }

    @Override
    public EquipmentEntity requestToEntity(EquipmentRequest req) {
        return EquipmentEntity
                .builder()
                .name(req.getName())
                .price(req.getPrice())
                .count(req.getCount())
                .build();
    }

    @Override
    public EquipmentResponse entityToResponse(EquipmentEntity entity) {
        return EquipmentResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .count(entity.getCount())
                .build();
    }

    @Override
    public EquipmentEntity responseToEntity(EquipmentResponse equipmentResponse) {
        return null;
    }
}
