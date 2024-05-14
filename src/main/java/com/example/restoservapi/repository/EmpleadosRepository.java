package com.example.restoservapi.repository;

import com.example.restoservapi.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long>{
    Optional<Empleados> findEmpleadosByEmplId(Long emplId);

}
