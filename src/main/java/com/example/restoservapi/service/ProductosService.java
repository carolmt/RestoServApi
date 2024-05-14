package com.example.restoservapi.service;

import com.example.restoservapi.model.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductosService {
    Optional<Productos> getProductoByProdID(Long prodId);
    Optional<Productos> getProductosByNomProdIgnoreCase(String nomProd);
    List<Productos> getAllProductos();
}
