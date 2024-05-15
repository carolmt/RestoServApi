package com.example.restoservapi.service;
import com.example.restoservapi.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriasByName(String nom_cat);

    void saveCategorias(Categoria categoria);
    void deleteCategoriasById(Long catId);

}
