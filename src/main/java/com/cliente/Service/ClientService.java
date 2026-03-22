package com.cliente.Service;

import com.cliente.Entity.Client;
import com.cliente.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> get(Long id) {
        return clientRepository.findById(id);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    public List<Client> findByParcialName(String name) {
        return clientRepository.findByNameContaining(name);
    }
}
