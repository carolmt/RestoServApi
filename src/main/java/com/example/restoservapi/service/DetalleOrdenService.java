package com.example.restoservapi.service;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Interfaz que define los métodos que se implementarán en la clase DetalleOrdenServiceImpl.
 * Estos métodos se utilizan para realizar operaciones CRUD sobre la tabla DetalleOrden de la base de datos.
 ***************************************************************************************************************/
public interface DetalleOrdenService {
    Optional<DetalleOrden>getDetalleOrdenById(Long detalleId);
    Optional<List<DetalleOrden>>getAllDetalleOrden();
    void deleteDetalleOrdenById(Long detalleId);
    DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden);
    DetalleOrden updateDetalleOrden(DetalleOrden detalleOrden);
    void deleteByOrden(Orden orden);
}
