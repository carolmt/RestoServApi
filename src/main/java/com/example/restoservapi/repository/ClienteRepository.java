package com.example.restoservapi.repository;

import com.example.restoservapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que extiende de JpaRepository para realizar operaciones CRUD sobre la tabla Cliente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Métodos sin implementar que se usaran para realizar consultas personalizadas.
     */
    Optional<Cliente>findClienteByTelf(Long telf);
    List<Cliente>findAll();
    void deleteClienteByTelf(Long telf);
}
