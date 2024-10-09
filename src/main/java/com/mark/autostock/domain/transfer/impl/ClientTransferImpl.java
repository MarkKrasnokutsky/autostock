package com.mark.autostock.domain.transfer.impl;

import com.mark.autostock.domain.dto.request.ClientRequest;
import com.mark.autostock.domain.dto.response.ClientResponse;
import com.mark.autostock.domain.entity.ClientEntity;
import com.mark.autostock.domain.transfer.TransferI;
import org.springframework.stereotype.Service;

@Service
public class ClientTransferImpl implements TransferI<ClientRequest, ClientResponse, ClientEntity> {
    @Override
    public ClientResponse requestToResponse(ClientRequest req) {
        return ClientResponse
                .builder()
                .fullName(req.getFullName())
                .phoneNumber(req.getPhoneNumber())
                .dateOfBirth(req.getDateOfBirth())
                .build();
    }

    @Override
    public ClientEntity requestToEntity(ClientRequest req) {
        return ClientEntity
                .builder()
                .fullName(req.getFullName())
                .phoneNumber(req.getPhoneNumber())
                .dateOfBirth(req.getDateOfBirth())
                .build();
    }

    @Override
    public ClientResponse entityToResponse(ClientEntity entity) {
        return ClientResponse
                .builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .dateOfBirth(entity.getDateOfBirth())
                .build();
    }

    @Override
    public ClientEntity responseToEntity(ClientResponse res) {
        return ClientEntity
                .builder()
                .fullName(res.getFullName())
                .phoneNumber(res.getPhoneNumber())
                .dateOfBirth(res.getDateOfBirth())
                .build();
    }
}
