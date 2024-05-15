package com.example.restoservapi.service;

import com.example.restoservapi.model.Producto;
import com.example.restoservapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<Producto> getProductoByProdID(Long prodId) {
        return productoRepository.findProductosByProdId(prodId);
    }

    @Override
    public Optional<Producto> getProductosByNomProdIgnoreCase(String nomProd) {
        return productoRepository.findProductosByNomProdIgnoreCase(nomProd);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
}
