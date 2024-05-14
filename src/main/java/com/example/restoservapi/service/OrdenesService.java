package com.example.restoservapi.service;

import com.example.restoservapi.model.Ordenes;

import java.util.List;
import java.util.Optional;

public interface OrdenesService {
    Optional<List<Ordenes>> getAllOrdenes();
    Optional<Ordenes> getOrdenesById(Long ordenId);
    void deleteOrdenesById(Long ordenId);
    Ordenes saveOrdenes(Ordenes ordenes);
    Ordenes updateOrdenes(Ordenes ordenes);
}
