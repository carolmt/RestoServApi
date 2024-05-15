package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> getClienteByTelf(Long telf) {
        return clienteRepository.findClienteByTelf(telf);
    }

    @Override
    public Optional<List<Cliente>> getAllClientes() {
        return Optional.of(clienteRepository.findAll());
    }

    @Override
    public void deleteClienteByTelf(Long telf) {
        clienteRepository.deleteClienteByTelf(telf);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
