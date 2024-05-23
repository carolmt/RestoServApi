package com.example.restoservapi.service;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{
    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    @Override
    public Optional<DetalleOrden> getDetalleOrdenById(Long detalleId) {
        return detalleOrdenRepository.findDetalleOrdenByDetalleId(detalleId);
    }

    @Override
    public Optional<List<DetalleOrden>> getAllDetalleOrden() {
        return Optional.of(detalleOrdenRepository.findAll());
    }

    @Override
    public void deleteDetalleOrdenById(Long detalleId) {
        detalleOrdenRepository.deleteDetalleOrdenByDetalleId(detalleId);
    }

    @Override
    public void deleteByOrden(Orden orden) {
        detalleOrdenRepository.deleteByOrden(orden);
    }

    @Override
    public DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public DetalleOrden updateDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
}
