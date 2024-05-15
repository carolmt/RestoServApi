package com.example.restoservapi.repository;

import com.example.restoservapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> getCategoriasByNomCatIgnoreCase(String nomCat);

    void deleteCategoriasByCatId(Long catId);
}
