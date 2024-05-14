package com.example.restoservapi.service;

import com.example.restoservapi.model.Ordenes;
import com.example.restoservapi.repository.OrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenesServiceImpl implements OrdenesService{
    private final OrdenesRepository ordenesRepository;

    @Autowired
    public OrdenesServiceImpl(OrdenesRepository ordenesRepository) {
        this.ordenesRepository = ordenesRepository;
    }

    @Override
    public Optional<List<Ordenes>> getAllOrdenes() {
        return Optional.of(ordenesRepository.findAll());
    }

    @Override
    public Optional<Ordenes> getOrdenesById(Long ordenId) {
        return ordenesRepository.findOrdenesByOrdenId(ordenId);
    }

    @Override
    public void deleteOrdenesById(Long ordenId) {
        ordenesRepository.deleteOrdenesByOrdenId(ordenId);
    }

    @Override
    public Ordenes saveOrdenes(Ordenes ordenes) {
        return ordenesRepository.save(ordenes);
    }

    @Override
    public Ordenes updateOrdenes(Ordenes ordenes) {
        return ordenesRepository.save(ordenes);
    }
}
