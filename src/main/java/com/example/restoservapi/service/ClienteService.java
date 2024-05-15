package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> getClienteByTelf(Long telf);
    Optional<List<Cliente>> getAllClientes();
    void deleteClienteByTelf(Long telf);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
}
