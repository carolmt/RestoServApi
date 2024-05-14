package com.example.restoservapi.service;

import com.example.restoservapi.model.Productos;
import com.example.restoservapi.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService{
    private final ProductosRepository productosRepository;

    @Autowired
    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public Optional<Productos> getProductoByProdID(Long prodId) {
        return productosRepository.findProductosByProdId(prodId);
    }

    @Override
    public Optional<Productos> getProductosByNomProdIgnoreCase(String nomProd) {
        return productosRepository.findProductosByNomProdIgnoreCase(nomProd);
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }
}
