package com.example.restoservapi.service;
import com.example.restoservapi.model.Categorias;

import java.util.List;
import java.util.Optional;

public interface CategoriasService {
    List<Categorias> getAllCategorias();
    Optional<Categorias> getCategoriasByName(String nom_cat);

    void saveCategorias(Categorias categoria);
    void deleteCategoriasById(Long catId);

}
