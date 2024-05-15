package com.example.restoservapi.service;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.mapper.OrdenMapper;
import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.model.Producto;
import com.example.restoservapi.repository.OrdenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {
    private final OrdenRepository ordenRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    public Optional<List<Orden>> getAllOrdenes() {
        return Optional.of(ordenRepository.findAll());
    }

    @Override
    public Optional<Orden> getOrdenesById(Long ordenId) {
        return ordenRepository.findOrdenesByOrdenId(ordenId);
    }

    @Override
    public void deleteOrdenesById(Long ordenId) {
        ordenRepository.deleteOrdenesByOrdenId(ordenId);
    }

   @Override
    public OrdenDTO saveOrdenes(Orden orden) {
       return OrdenMapper.toOrdenDTO(ordenRepository.save(orden));
   }
    @Override
    public OrdenDTO updateOrdenes(Orden orden) {
        ordenRepository.findOrdenesByOrdenId(orden.getOrdenId());
        return OrdenMapper.toOrdenDTO(ordenRepository.save(orden));
    }
}
