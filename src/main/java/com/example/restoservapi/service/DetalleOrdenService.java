package com.example.restoservapi.service;

import com.example.restoservapi.model.DetalleOrden;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenService {
    Optional<DetalleOrden>getDetalleOrdenById(Long detalleId);
    Optional<List<DetalleOrden>>getAllDetalleOrden();
    void deleteDetalleOrdenById(Long detalleId);
    DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden);
    DetalleOrden updateDetalleOrden(DetalleOrden detalleOrden);
}
