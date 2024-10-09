package com.mark.autostock.service.impl;

import com.mark.autostock.domain.dto.request.ClientRequest;
import com.mark.autostock.domain.dto.response.ClientResponse;
import com.mark.autostock.domain.entity.ClientEntity;
import com.mark.autostock.domain.transfer.impl.ClientTransferImpl;
import com.mark.autostock.repository.ClientRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements CrudServiceI<ClientRequest, ClientResponse, Long> {

    private final ClientTransferImpl clientTransfer;
    private final ClientRepository clientRepository;

    public List<ClientResponse> getAll() {
        List<ClientResponse> employerResList = new ArrayList<>();
        List<ClientEntity> entities = clientRepository.findAll();
        for (ClientEntity entity : entities){
            employerResList.add(clientTransfer.entityToResponse(entity));
        }
        return employerResList;
    }

    public ClientResponse getById(Long id) {
        ClientEntity entity = clientRepository.findById(id).orElse(null);
        return clientTransfer.entityToResponse(entity);
    }

    public ClientResponse add(ClientRequest client) {
        ClientEntity entity = clientTransfer.requestToEntity(client);
        clientRepository.save(entity);
        return clientTransfer.entityToResponse(entity);
    }

    public void delete(Long id) {
        ClientEntity entity = clientRepository.findById(id).get();
        clientRepository.delete(entity);
    }

    public ClientResponse change(Long id, ClientRequest client) {
        ClientEntity entity = clientRepository.findById(id).get();
        // REQ to E
        entity.setFullName(client.getFullName());
        entity.setPhoneNumber(client.getPhoneNumber());
        entity.setDateOfBirth(client.getDateOfBirth());
        // ----------------------------------------------------------------
        clientRepository.save(entity);
        return clientTransfer.entityToResponse(entity);
    }
}
