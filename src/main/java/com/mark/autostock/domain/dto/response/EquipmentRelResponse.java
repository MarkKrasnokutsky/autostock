package com.mark.autostock.domain.dto.response;

import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.domain.entity.EquipmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRelResponse {
    private Long id;
    private AutomobileEntity automobile;
    private EquipmentEntity equipment;
}
