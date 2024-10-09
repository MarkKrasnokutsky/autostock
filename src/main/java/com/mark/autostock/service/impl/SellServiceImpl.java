package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.SellRequest;
import com.mark.autostock.domain.dto.response.SellResponse;
import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.domain.entity.SellEntity;
import com.mark.autostock.repository.AutomobileRepository;
import com.mark.autostock.repository.ClientRepository;
import com.mark.autostock.repository.EmployerRepository;
import com.mark.autostock.repository.SellRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellServiceImpl implements CrudServiceI<SellRequest, SellResponse, Long> {
    private final SellRepository sellRepository;
    private final EmployerRepository employerRepository;
    private final AutomobileRepository automobileRepository;
    private final ClientRepository clientRepository;
    @Override
    public List<SellResponse> getAll() {
        List<SellResponse> sellResList = new ArrayList<>();
        List<SellEntity> entities = sellRepository.findAll();
        for (SellEntity entity : entities){
            SellResponse sellRes = new SellResponse();
            sellRes.setId(entity.getId());
            sellRes.setAutomobile(entity.getAutomobile());
            sellRes.setClient(entity.getClient());
            sellRes.setEmployer(entity.getEmployer());
            sellRes.setSellDate(entity.getSellDate());
            sellRes.setTotalCost(entity.getTotalCost());
            sellRes.setStatus(entity.getStatus());
            sellResList.add(sellRes);
        }
        return sellResList;
    }

    @Override
    public SellResponse getById(Long id) {
        SellEntity entity = sellRepository.findById(id).orElse(null);
        SellResponse sellRes = new SellResponse();
        sellRes.setId(entity.getId());
        sellRes.setAutomobile(entity.getAutomobile());
        sellRes.setClient(entity.getClient());
        sellRes.setEmployer(entity.getEmployer());
        sellRes.setSellDate(entity.getSellDate());
        sellRes.setTotalCost(entity.getTotalCost());
        sellRes.setStatus(entity.getStatus());
        return sellRes;
    }

    @Override
    public SellResponse add(SellRequest sellReq) {
        SellEntity entity = new SellEntity();
        entity.setAutomobile(automobileRepository.findById(sellReq.getAutomobileId()).get());
        entity.setClient(clientRepository.findById(sellReq.getClientId()).get());
        entity.setEmployer(employerRepository.findById(sellReq.getEmployerId()).get());
        entity.setSellDate(sellReq.getSellDate());
        entity.setTotalCost(sellReq.getTotalCost());
        entity.setStatus(sellReq.getStatus());
        sellRepository.save(entity);
        AutomobileEntity automobileEntity = automobileRepository.findById(sellReq.getAutomobileId()).get();
        automobileEntity.setStatus("Продано");
        automobileRepository.save(automobileEntity);
        SellResponse sellRes = new SellResponse();
        sellRes.setId(entity.getId());
        sellRes.setAutomobile(entity.getAutomobile());
        sellRes.setClient(entity.getClient());
        sellRes.setEmployer(entity.getEmployer());
        sellRes.setSellDate(entity.getSellDate());
        sellRes.setTotalCost(entity.getTotalCost());
        sellRes.setStatus(entity.getStatus());
        return sellRes;
    }

    @Override
    public void delete(Long id) {
        SellEntity entity = sellRepository.findById(id).get();
        sellRepository.delete(entity);
        AutomobileEntity automobileEntity = automobileRepository.findById(entity.getAutomobile().getId()).get();
        automobileEntity.setStatus("В продаже");
        automobileRepository.save(automobileEntity);
    }

    @Override
    public SellResponse change(Long id, SellRequest sellReq) {
        SellEntity entity = sellRepository.findById(id).get();
        entity.setAutomobile(automobileRepository.findById(sellReq.getAutomobileId()).get());
        entity.setClient(clientRepository.findById(sellReq.getClientId()).get());
        entity.setEmployer(employerRepository.findById(sellReq.getEmployerId()).get());
        entity.setSellDate(sellReq.getSellDate());
        entity.setTotalCost(sellReq.getTotalCost());
        entity.setStatus(sellReq.getStatus());
        sellRepository.save(entity);
        SellResponse sellRes = new SellResponse();
        sellRes.setId(entity.getId());
        sellRes.setAutomobile(entity.getAutomobile());
        sellRes.setClient(entity.getClient());
        sellRes.setEmployer(entity.getEmployer());
        sellRes.setSellDate(entity.getSellDate());
        sellRes.setTotalCost(entity.getTotalCost());
        sellRes.setStatus(entity.getStatus());
        return sellRes;
    }
}
