package com.example.restoservapi.repository;

import com.example.restoservapi.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    Optional<Categorias> getCategoriasByNomCatIgnoreCase(String nomCat);

    void deleteCategoriasByCatId(Long catId);
}
