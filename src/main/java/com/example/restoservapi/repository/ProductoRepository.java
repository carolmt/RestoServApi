package com.example.restoservapi.repository;

import com.example.restoservapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de la entidad Producto
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findProductosByNomProdIgnoreCase(String nomProd);
    Optional<Producto> findProductosByProdId(Long prodId);
}
