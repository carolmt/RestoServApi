package com.example.restoservapi.service;

import com.example.restoservapi.model.Categoria;
import com.example.restoservapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que implementa los métodos de la interfaz CategoriaService
 ***************************************************************************************************************/
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    /**
     * Constructor de la clase  CategoriaServiceImpl
     * @param categoriaRepository
     */
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Método que obtiene todas las categorias
     * @return lista de categorias
     */
    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }


    /**
     * Método que obtiene una categoria por su nombre
     * @param nomCat de la categoria
     * @return categoria
     */
    @Override
    public Optional<Categoria> getCategoriasByName(String nomCat) {
        if(nomCat == null) {
            throw new IllegalArgumentException("Nombre de categoria no puede ser nulo");
        }
        return categoriaRepository.getCategoriasByNomCatIgnoreCase(nomCat);
    }

    /**
     * Método que guarda una categoria
     * @param categoria
     */
    @Override
    public void saveCategorias(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    /**
     * Método que elimina una categoria
     * @param catId de categoria
     */
    @Override
    public void deleteCategoriasById(Long catId) {
        categoriaRepository.deleteCategoriasByCatId(catId);
    }
}
