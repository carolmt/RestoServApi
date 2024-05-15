package com.example.restoservapi.service;

import com.example.restoservapi.model.Categoria;
import com.example.restoservapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriasByName(String nomCat) {
        if(nomCat == null) {
            throw new IllegalArgumentException("Nombre de categoria no puede ser nulo");
        }
        return categoriaRepository.getCategoriasByNomCatIgnoreCase(nomCat);
    }

    @Override
    public void saveCategorias(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoriasById(Long catId) {
        categoriaRepository.deleteCategoriasByCatId(catId);
    }
}
