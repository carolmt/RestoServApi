package com.example.restoservapi.service;

import com.example.restoservapi.model.Categorias;
import com.example.restoservapi.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServiceImpl implements CategoriasService{

    private final CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @Override
    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    @Override
    public Optional<Categorias> getCategoriasByName(String nomCat) {
        if(nomCat == null) {
            throw new IllegalArgumentException("Nombre de categoria no puede ser nulo");
        }
        return categoriasRepository.getCategoriasByNomCatIgnoreCase(nomCat);
    }

    @Override
    public void saveCategorias(Categorias categoria) {
        categoriasRepository.save(categoria);
    }

    @Override
    public void deleteCategoriasById(Long catId) {
        categoriasRepository.deleteCategoriasByCatId(catId);
    }
}
