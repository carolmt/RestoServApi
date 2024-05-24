package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.repository.ClienteRepository;
import com.example.restoservapi.repository.DetalleOrdenRepository;
import com.example.restoservapi.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que implementa los métodos de la interfaz ClienteService
 ***************************************************************************************************************/
@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final OrdenRepository ordenRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, OrdenRepository ordenRepository, DetalleOrdenRepository detalleOrdenRepository) {
        this.clienteRepository = clienteRepository;
        this.ordenRepository = ordenRepository;
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    @Override
    public Optional<Cliente> getClienteByTelf(Long telf) {
        return clienteRepository.findClienteByTelf(telf);
    }

    @Override
    public Optional<List<Cliente>> getAllClientes() {
        return Optional.of(clienteRepository.findAll());
    }

    @Transactional
    @Override
    public void deleteClienteByTelf(Long telf) {
        Optional<Cliente> cliente = clienteRepository.findClienteByTelf(telf);
        if (cliente.isPresent()) {
            List<Orden> ordenes = ordenRepository.findByCliente(cliente.get());
            for (Orden orden : ordenes) {
                detalleOrdenRepository.deleteByOrden(orden);
                ordenRepository.delete(orden);
            }
            clienteRepository.delete(cliente.get());
        }
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
