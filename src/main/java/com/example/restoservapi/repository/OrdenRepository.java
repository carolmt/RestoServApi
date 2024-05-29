package com.example.restoservapi.repository;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Repositorio de la entidad Orden
 */
@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findAll();
    Orden findOrdenesByOrdenId(Long ordenId);
    List<Orden> findByCliente(Cliente cliente);
    List<Orden> findOrdenByHecho(Boolean hecho);
}
