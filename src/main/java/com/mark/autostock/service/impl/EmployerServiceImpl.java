package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.EmployerRequest;
import com.mark.autostock.domain.dto.response.EmployerResponse;
import com.mark.autostock.domain.entity.EmployerEntity;
import com.mark.autostock.repository.EmployerRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements CrudServiceI<EmployerRequest, EmployerResponse, Long> {
    private final EmployerRepository employerRepository;
    @Override
    public List<EmployerResponse> getAll() {
        List<EmployerResponse> employerResList = new ArrayList<>();
        List<EmployerEntity> entities = employerRepository.findAll();
        for (EmployerEntity entity : entities){
            EmployerResponse employerRes = new EmployerResponse();
            employerRes.setId(entity.getId());
            employerRes.setFullName(entity.getFullName());
            employerRes.setPhoneNumber(entity.getPhoneNumber());
            employerRes.setPosition(entity.getPosition());
            employerRes.setSalary(entity.getSalary());
            employerResList.add(employerRes);
        }
        return employerResList;
    }

    @Override
    public EmployerResponse getById(Long id) {
        EmployerEntity entity = employerRepository.findById(id).orElse(null);
        EmployerResponse employerRes = new EmployerResponse();
        employerRes.setId(entity.getId());
        employerRes.setFullName(entity.getFullName());
        employerRes.setPhoneNumber(entity.getPhoneNumber());
        employerRes.setPosition(entity.getPosition());
        employerRes.setSalary(entity.getSalary());
        return employerRes;
    }

    @Override
    public EmployerResponse add(EmployerRequest employer) {
        EmployerEntity entity = new EmployerEntity();
        entity.setFullName(employer.getFullName());
        entity.setPhoneNumber(employer.getPhoneNumber());
        entity.setPosition(employer.getPosition());
        entity.setSalary(employer.getSalary());
        employerRepository.save(entity);
        EmployerResponse employerRes = new EmployerResponse();
        employerRes.setId(entity.getId());
        employerRes.setFullName(entity.getFullName());
        employerRes.setPhoneNumber(entity.getPhoneNumber());
        employerRes.setPosition(entity.getPosition());
        employerRes.setSalary(entity.getSalary());
        return employerRes;
    }

    @Override
    public void delete(Long id) {
        EmployerEntity entity = employerRepository.findById(id).get();
        employerRepository.delete(entity);
    }

    @Override
    public EmployerResponse change(Long id, EmployerRequest employer) {
        EmployerEntity entity = employerRepository.findById(id).get();
        entity.setFullName(employer.getFullName());
        entity.setPhoneNumber(employer.getPhoneNumber());
        entity.setPosition(employer.getPosition());
        entity.setSalary(employer.getSalary());
        employerRepository.save(entity);
        EmployerResponse employerRes = new EmployerResponse();
        employerRes.setId(entity.getId());
        employerRes.setFullName(entity.getFullName());
        employerRes.setPhoneNumber(entity.getPhoneNumber());
        employerRes.setPosition(entity.getPosition());
        employerRes.setSalary(entity.getSalary());
        return employerRes;
    }
}
