package com.example.restoservapi.repository;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface que extiende de JpaRepository para realizar operaciones CRUD sobre la entidad DetalleOrden.
 */
@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

    Optional<DetalleOrden>findDetalleOrdenByDetalleId(Long detalleId);
    List<DetalleOrden> findAll();
    void deleteDetalleOrdenByDetalleId(Long detalleId);
    @Transactional
    void deleteByOrden(Orden orden);
}
