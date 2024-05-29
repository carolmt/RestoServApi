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
/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que implementa los métodos de la interfaz OrdenService
 ***************************************************************************************************************/
@Service
public class OrdenServiceImpl implements OrdenService {
    private final OrdenRepository ordenRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;


    /**
     * Constructor de la clase
     * @param ordenRepository
     * @param empleadoRepository
     * @param clienteRepository
     * @param detalleOrdenRepository
     */
    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository, DetalleOrdenRepository detalleOrdenRepository) {
        this.ordenRepository = ordenRepository;
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    /**
     * Método que añade un detalle de orden a una orden
     * @param ordenId
     * @param detalleOrden
     * @return orden
     */
    public Orden addDetalleOrdenToOrden(Long ordenId, DetalleOrden detalleOrden) {
        Orden orden = ordenRepository.findOrdenesByOrdenId(ordenId);
        orden.addDetalleOrden(detalleOrden);
        return ordenRepository.save(orden); // Guarda los cambios en la orden
    }

    /**
     * Método que devuelve una lista de ordenes
     * @return lista de ordenes
     */
    @Override
    public Optional<List<Orden>> getAllOrdenes() {
        return Optional.of(ordenRepository.findAll());
    }

    /**
     * Método que devuelve una orden por su id
     * @param ordenId
     * @return orden
     */
    @Override
    public Orden getOrdenesById(Long ordenId) {
        return ordenRepository.findOrdenesByOrdenId(ordenId);
    }

    /**
     * Método que devuelve una lista de ordenes por cliente
     * @param cliente
     * @return lista de ordenes
     */
    @Override
    public List<Orden> findOrdenesByCliente(Cliente cliente) {
        return ordenRepository.findByCliente(cliente);
    }

    /**
     * Método que elimina una orden por su id
     * @param ordenId
     */
    @Transactional
    @Override
    public void deleteOrdenesById(Long ordenId) {
        Orden orden = ordenRepository.findOrdenesByOrdenId(ordenId);
        if (orden != null) {
            detalleOrdenRepository.deleteByOrden(orden);
            ordenRepository.delete(orden);
        }
    }

    /**
     * Método que elimina una orden
     * @param orden
     * @return orden
     */
    @Override
    public OrdenDTO saveOrden(Orden orden) {
        return OrdenMapper.toOrdenDTO(ordenRepository.save(orden));
    }

    /**
     * Método que actualiza una orden
     * @param orden
     * @return orden
     */
    @Override
    public OrdenDTO updateOrdenes(Orden orden) {
        ordenRepository.findOrdenesByOrdenId(orden.getOrdenId());
        return OrdenMapper.toOrdenDTO(ordenRepository.save(orden));
    }

    /**
     * Método que actualiza una orden
     * @param orden
     * @return orden
     */
    @Override
    public Orden updateOrden(Orden orden) {
        ordenRepository.findOrdenesByOrdenId(orden.getOrdenId());
        return ordenRepository.save(orden);
    }

    /**
     * Método que devuelve una lista de ordenes por el estado de hecho
     * @param hecho
     * @return lista de ordenes
     */
    @Override
    public List<Orden> findOrdenByHecho(Boolean hecho) {
        return ordenRepository.findOrdenByHecho(hecho);
    }
}

