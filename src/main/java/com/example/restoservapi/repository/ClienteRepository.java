package com.example.restoservapi.repository;

import com.example.restoservapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente>findClienteByTelf(Long telf);
    List<Cliente>findAll();
    void deleteClienteByTelf(Long telf);
}
