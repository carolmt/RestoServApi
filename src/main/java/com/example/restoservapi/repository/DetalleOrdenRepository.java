package com.example.restoservapi.repository;

import com.example.restoservapi.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

    Optional<DetalleOrden>findDetalleOrdenByDetalleId(Long detalleId);
    List<DetalleOrden> findAll();
    void deleteDetalleOrdenByDetalleId(Long detalleId);
}
