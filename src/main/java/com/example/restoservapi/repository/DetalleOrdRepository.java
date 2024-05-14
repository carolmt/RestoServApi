package com.example.restoservapi.repository;

import com.example.restoservapi.model.Detalle_Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdRepository extends JpaRepository<Detalle_Ordenes, Long> {
}
