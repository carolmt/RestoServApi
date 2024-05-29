package com.example.restoservapi.service;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.model.Orden;

import java.util.List;
import java.util.Optional;
/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Interfaz que define los métodos que se implementarán en la clase OrdenServiceImpl.
 * Estos métodos se utilizan para realizar operaciones CRUD sobre la tabla Ordenes de la base de datos.
 ***************************************************************************************************************/
public interface OrdenService {
    Optional<List<Orden>> getAllOrdenes();
    Orden getOrdenesById(Long ordenId);
    void deleteOrdenesById(Long ordenId);
    List<Orden> findOrdenesByCliente(Cliente cliente);
    List<Orden> findOrdenByHecho(Boolean hecho);

    OrdenDTO saveOrden(Orden orden);
    OrdenDTO updateOrdenes(Orden orden);
    Orden updateOrden(Orden orden);
}
