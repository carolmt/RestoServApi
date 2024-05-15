package com.example.restoservapi.service;

import com.example.restoservapi.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Optional<Producto> getProductoByProdID(Long prodId);
    Optional<Producto> getProductosByNomProdIgnoreCase(String nomProd);
    List<Producto> getAllProductos();
}
