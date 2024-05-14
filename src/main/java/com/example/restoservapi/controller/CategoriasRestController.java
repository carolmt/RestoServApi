package com.example.restoservapi.controller;

import com.example.restoservapi.model.Categorias;
import com.example.restoservapi.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RestoServ/api/categorias")
public class CategoriasRestController {
    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasRestController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("")
    public ResponseEntity<List<Categorias>>getAllCategorias(){
        return ResponseEntity.ok(categoriasService.getAllCategorias());
    }

    @GetMapping("/{nomCat}")
    public ResponseEntity<Categorias> getCategoriasByName(@PathVariable String nomCat){
        return this.categoriasService.getCategoriasByName(nomCat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
