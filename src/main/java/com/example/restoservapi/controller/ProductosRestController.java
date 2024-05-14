package com.example.restoservapi.controller;

import com.example.restoservapi.model.Productos;
import com.example.restoservapi.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RestoServ/api/productos")
public class ProductosRestController {
    private final ProductosService productosService;

    @Autowired
    public ProductosRestController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("")
    public List<Productos> getAllProductos(){
        return productosService.getAllProductos();
    }

    @GetMapping("/{nomProd}")
    public ResponseEntity<Productos> getProductosByNomProdIgnoreCase(@PathVariable String nomProd){
        return this.productosService.getProductosByNomProdIgnoreCase(nomProd)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
