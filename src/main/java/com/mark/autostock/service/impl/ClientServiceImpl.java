package com.mark.autostock.service.impl;

import com.mark.autostock.entity.ClientEntity;
import com.mark.autostock.repository.ClientRepository;
import com.mark.autostock.service.CrudServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements CrudServiceI<ClientEntity, Long> {

    private final ClientRepository clientRepository;

    public List<ClientEntity> getAll() {
        return clientRepository.findAll();
    }

    public ClientEntity getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientEntity add(ClientEntity client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        ClientEntity entity = clientRepository.findById(id).get();
        clientRepository.delete(entity);
    }

    public ClientEntity change(Long id, ClientEntity client) {
        ClientEntity entity = clientRepository.findById(id).get();
        entity.setFullName(client.getFullName());
        entity.setPhoneNumber(client.getPhoneNumber());
        entity.setDateOfBirth(client.getDateOfBirth());
        return clientRepository.save(entity);
    }
}
