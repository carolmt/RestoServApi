package com.example.restoservapi.service;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.mapper.OrdenMapper;
import com.example.restoservapi.model.*;
import com.example.restoservapi.repository.ClienteRepository;
import com.example.restoservapi.repository.DetalleOrdenRepository;
import com.example.restoservapi.repository.EmpleadoRepository;
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
    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;


    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository, DetalleOrdenRepository detalleOrdenRepository) {
        this.ordenRepository = ordenRepository;
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    public Orden addDetalleOrdenToOrden(Long ordenId, DetalleOrden detalleOrden) {
        Orden orden = ordenRepository.findOrdenesByOrdenId(ordenId);
        orden.addDetalleOrden(detalleOrden);
        return ordenRepository.save(orden); // Guarda los cambios en la orden
    }

    @Override
    public Optional<List<Orden>> getAllOrdenes() {
        return Optional.of(ordenRepository.findAll());
    }

    @Override
    public Orden getOrdenesById(Long ordenId) {
        return ordenRepository.findOrdenesByOrdenId(ordenId);
    }

    @Override
    public List<Orden> findOrdenesByCliente(Cliente cliente) {
        return ordenRepository.findByCliente(cliente);
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
