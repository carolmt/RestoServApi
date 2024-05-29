package com.example.restoservapi.controller;

import com.example.restoservapi.model.Categoria;
import com.example.restoservapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador de Categorias
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/categorias")
public class CategoriaRestController {


    private final CategoriaService categoriaService;

    /**
     * Constructor de la clase
     * @param categoriaService
     */
    @Autowired
    public CategoriaRestController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Método que obtiene todas las categorias
     * @return una ResponseEntity con la lista de categorias
     */
    @GetMapping("")
    public ResponseEntity<List<Categoria>>getAllCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    /**
     * Método que obtiene una categoria por su nombre
     * @param nomCat
     * @return una ResponseEntity con en objeto categoria
     */
    @GetMapping("/{nomCat}")
    public ResponseEntity<Categoria> getCategoriasByName(@PathVariable String nomCat){
        return this.categoriaService.getCategoriasByName(nomCat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
