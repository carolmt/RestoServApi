package com.example.restoservapi.repository;

import com.example.restoservapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findProductosByNomProdIgnoreCase(String nomProd);
    Optional<Producto> findProductosByProdId(Long prodId);
}
