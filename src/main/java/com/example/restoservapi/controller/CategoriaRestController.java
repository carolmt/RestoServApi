package com.example.restoservapi.controller;

import com.example.restoservapi.model.Categoria;
import com.example.restoservapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/categorias")
public class CategoriaRestController {
    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaRestController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Categoria>>getAllCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping("/{nomCat}")
    public ResponseEntity<Categoria> getCategoriasByName(@PathVariable String nomCat){
        return this.categoriaService.getCategoriasByName(nomCat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
