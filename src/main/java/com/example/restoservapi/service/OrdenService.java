package com.example.restoservapi.service;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.model.Orden;

import java.util.List;
import java.util.Optional;

public interface OrdenService {
    Optional<List<Orden>> getAllOrdenes();
    Orden getOrdenesById(Long ordenId);
    void deleteOrdenesById(Long ordenId);
    List<Orden> findOrdenesByCliente(Cliente cliente);
    List<Orden> findOrdenByHecho(Boolean hecho);

    OrdenDTO saveOrden(Orden orden);
    OrdenDTO updateOrdenes(Orden orden);
}
