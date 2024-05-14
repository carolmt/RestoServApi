package com.example.restoservapi.repository;

import com.example.restoservapi.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Productos, Long> {

    Optional<Productos> findProductosByNomProdIgnoreCase(String nomProd);
    Optional<Productos> findProductosByProdId(Long prodId);
}
