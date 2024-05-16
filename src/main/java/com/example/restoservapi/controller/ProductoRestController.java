package com.example.restoservapi.controller;

import com.example.restoservapi.model.Producto;
import com.example.restoservapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/productos")
public class ProductoRestController {
    private final ProductoService productoService;

    @Autowired
    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("")
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{nomProd}")
    public ResponseEntity<Producto> getProductosByNomProdIgnoreCase(@PathVariable String nomProd){
        return this.productoService.getProductosByNomProdIgnoreCase(nomProd)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
