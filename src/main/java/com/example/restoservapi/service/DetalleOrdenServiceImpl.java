package com.example.restoservapi.service;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que implementa los métodos de la interfaz DetalleOrdenService
 ***************************************************************************************************************/
@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{
    private final DetalleOrdenRepository detalleOrdenRepository;

    /**
     * Constructor de la clase
     * @param detalleOrdenRepository
     */
    @Autowired
    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    /**
     * Método que obtiene un detalle de orden por su id
     * @param detalleId
     * @return Detalle de orden
     */
    @Override
    public Optional<DetalleOrden> getDetalleOrdenById(Long detalleId) {
        return detalleOrdenRepository.findDetalleOrdenByDetalleId(detalleId);
    }

    /**
     * Método que obtiene todos los detalles de orden
     * @return Lista de detalles de orden
     */
    @Override
    public Optional<List<DetalleOrden>> getAllDetalleOrden() {
        return Optional.of(detalleOrdenRepository.findAll());
    }

    /**
     * Método que elimina detalles de orden por su id
     * @param detalleId
     */
    @Override
    public void deleteDetalleOrdenById(Long detalleId) {
        detalleOrdenRepository.deleteDetalleOrdenByDetalleId(detalleId);
    }

    /**
     * Método que elimina detalles de orden por la orden
     * @param orden
     */
    @Override
    public void deleteByOrden(Orden orden) {
        detalleOrdenRepository.deleteByOrden(orden);
    }

    /**
     * Método que guarda un detalle de orden
     * @param detalleOrden
     * @return Detalle de orden
     */
    @Override
    public DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    /**
     * Método que actualiza un detalle de orden
     * @param detalleOrden
     * @return Detalle de orden
     */
    @Override
    public DetalleOrden updateDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
}
