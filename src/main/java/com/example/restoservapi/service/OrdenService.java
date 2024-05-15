package com.example.restoservapi.service;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Orden;

import java.util.List;
import java.util.Optional;

public interface OrdenService {
    Optional<List<Orden>> getAllOrdenes();
    Optional<Orden> getOrdenesById(Long ordenId);
    void deleteOrdenesById(Long ordenId);

    OrdenDTO saveOrdenes(Orden orden);
    OrdenDTO updateOrdenes(Orden orden);
}
