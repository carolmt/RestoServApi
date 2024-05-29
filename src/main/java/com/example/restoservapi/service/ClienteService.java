package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Interfaz que define los métodos que se implementarán en la clase ClienteServiceImpl.
 * Estos métodos se utilizan para realizar operaciones CRUD sobre la tabla Clientes de la base de datos.
 ***************************************************************************************************************/
public interface ClienteService {
    Optional<Cliente> getClienteByTelf(Long telf);
    Optional<List<Cliente>> getAllClientes();
    void deleteClienteByTelf(Long telf);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
}
