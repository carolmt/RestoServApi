package com.example.restoservapi.repository;

import com.example.restoservapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz que extiende de JpaRepository para realizar operaciones CRUD sobre la tabla Categoria.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     * Métodos sin implementar que se usaran para realizar consultas personalizadas.
     */
    Optional<Categoria> getCategoriasByNomCatIgnoreCase(String nomCat);
    void deleteCategoriasByCatId(Long catId);
}
