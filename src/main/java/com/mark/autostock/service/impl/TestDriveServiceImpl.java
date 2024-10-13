package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.TestDriveRequest;
import com.mark.autostock.domain.dto.response.SellResponse;
import com.mark.autostock.domain.dto.response.TestDriveResponse;
import com.mark.autostock.domain.entity.AutomobileEntity;
import com.mark.autostock.domain.entity.SellEntity;
import com.mark.autostock.domain.entity.TestDriveEntity;
import com.mark.autostock.repository.AutomobileRepository;
import com.mark.autostock.repository.ClientRepository;
import com.mark.autostock.repository.EmployerRepository;
import com.mark.autostock.repository.TestDriveRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestDriveServiceImpl implements CrudServiceI<TestDriveRequest, TestDriveResponse, Long> {
    private final TestDriveRepository testDriveRepository;
    private final AutomobileRepository automobileRepository;
    private final ClientRepository clientRepository;
    private final EmployerRepository employerRepository;

    @Override
    public List<TestDriveResponse> getAll() {
        List<TestDriveResponse> testDriveResList = new ArrayList<>();
        List<TestDriveEntity> entities = testDriveRepository.findAll();
        for (TestDriveEntity entity : entities){
            TestDriveResponse res = new TestDriveResponse();
            res.setId(entity.getId());
            res.setClient(entity.getClient());
            res.setAuto(entity.getAuto());
            res.setEmployer(entity.getEmployee());
            res.setDate(entity.getDate());
            testDriveResList.add(res);
        }
        return testDriveResList;
    }

    @Override
    public TestDriveResponse getById(Long id) {
        TestDriveEntity entity = testDriveRepository.findById(id).orElse(null);
        TestDriveResponse res = new TestDriveResponse();
        res.setId(entity.getId());
        res.setClient(entity.getClient());
        res.setAuto(entity.getAuto());
        res.setEmployer(entity.getEmployee());
        res.setDate(entity.getDate());
        return res;
    }

    @Override
    public TestDriveResponse add(TestDriveRequest req) {
        TestDriveEntity entity = new TestDriveEntity();
        entity.setAuto(automobileRepository.findById(req.getAutoId()).get());
        entity.setClient(clientRepository.findById(req.getClientId()).get());
        entity.setEmployee(employerRepository.findById(req.getEmployeeId()).get());
        entity.setDate(req.getDate());
        testDriveRepository.save(entity);
        TestDriveResponse res = new TestDriveResponse();
        res.setId(entity.getId());
        res.setClient(entity.getClient());
        res.setAuto(entity.getAuto());
        res.setEmployer(entity.getEmployee());
        res.setDate(entity.getDate());
        return res;
    }

    @Override
    public void delete(Long id) {
        TestDriveEntity entity = testDriveRepository.findById(id).get();
        testDriveRepository.delete(entity);
    }

    @Override
    public TestDriveResponse change(Long id, TestDriveRequest req) {
        TestDriveEntity entity = testDriveRepository.findById(id).get();
        entity.setAuto(automobileRepository.findById(req.getAutoId()).get());
        entity.setClient(clientRepository.findById(req.getClientId()).get());
        entity.setEmployee(employerRepository.findById(req.getEmployeeId()).get());
        entity.setDate(req.getDate());
        testDriveRepository.save(entity);
        TestDriveResponse res = new TestDriveResponse();
        res.setId(entity.getId());
        res.setClient(entity.getClient());
        res.setAuto(entity.getAuto());
        res.setEmployer(entity.getEmployee());
        res.setDate(entity.getDate());
        return res;
    }
}
