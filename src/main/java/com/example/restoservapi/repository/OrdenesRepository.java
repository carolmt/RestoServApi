package com.example.restoservapi.repository;

import com.example.restoservapi.model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

    List<Ordenes> findAll();
    Optional<Ordenes> findOrdenesByOrdenId(Long ordenId);
    void deleteOrdenesByOrdenId(Long ordenId);
}
