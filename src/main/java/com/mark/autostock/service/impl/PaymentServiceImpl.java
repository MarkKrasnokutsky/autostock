package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.PaymentRequest;
import com.mark.autostock.domain.dto.response.PaymentResponse;
import com.mark.autostock.domain.entity.*;
import com.mark.autostock.repository.PaymentRepository;
import com.mark.autostock.repository.SellRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements CrudServiceI<PaymentRequest, PaymentResponse, Long> {

    private final PaymentRepository paymentRepository;
    private final SellRepository sellRepository;

    @Override
    public List<PaymentResponse> getAll() {
        List<PaymentResponse> paymentResList = new ArrayList<>();
        List<PaymentEntity> entities = paymentRepository.findAll();
        for (PaymentEntity entity : entities){
            PaymentResponse paymentRes = PaymentResponse
                    .builder()
                    .paymentId(entity.getPaymentNumber())
                    .sell(entity.getSell())
                    .paymentDate(entity.getPaymentDate())
                    .paymentCost(entity.getPaymentAmount())
                    .paymentMethod(entity.getPaymentMethod())
                    .build();
            paymentResList.add(paymentRes);
        }
        return paymentResList;
    }

    @Override
    public PaymentResponse getById(Long id) {
        PaymentEntity entity = paymentRepository.findById(id).orElse(null);
        return PaymentResponse
                .builder()
                .paymentId(entity.getPaymentNumber())
                .sell(entity.getSell())
                .paymentDate(entity.getPaymentDate())
                .paymentCost(entity.getPaymentAmount())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }

    @Override
    public PaymentResponse add(PaymentRequest req) {
        PaymentEntity entity = new PaymentEntity();
        entity.setSell(sellRepository.findById(req.getSellId()).get());
        entity.setPaymentDate(req.getPaymentDate());
        entity.setPaymentAmount(req.getPaymentAmount());
        entity.setPaymentMethod(req.getPaymentMethod());
        paymentRepository.save(entity);
        SellEntity sellEntity = sellRepository.findById(req.getSellId()).get();
        sellEntity.setStatus("Оплачено");
        sellRepository.save(sellEntity);
        return PaymentResponse
                .builder()
                .paymentId(entity.getPaymentNumber())
                .sell(entity.getSell())
                .paymentDate(entity.getPaymentDate())
                .paymentCost(entity.getPaymentAmount())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }

    @Override
    public void delete(Long id) {
        PaymentEntity entity = paymentRepository.findById(id).get();
        paymentRepository.delete(entity);
        SellEntity sellEntity = sellRepository.findById(entity.getSell().getId()).get();
        sellEntity.setStatus("Не оплачено");
        sellRepository.save(sellEntity);
    }

    @Override
    public PaymentResponse change(Long id, PaymentRequest req) {
        PaymentEntity entity = paymentRepository.findById(id).get();
        entity.setSell(sellRepository.findById(req.getSellId()).get());
        entity.setPaymentDate(req.getPaymentDate());
        entity.setPaymentAmount(req.getPaymentAmount());
        entity.setPaymentMethod(req.getPaymentMethod());
        paymentRepository.save(entity);
        return PaymentResponse
                .builder()
                .paymentId(entity.getPaymentNumber())
                .sell(entity.getSell())
                .paymentDate(entity.getPaymentDate())
                .paymentCost(entity.getPaymentAmount())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }
}
