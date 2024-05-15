package com.example.restoservapi.repository;

import com.example.restoservapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    Optional<Empleado> findEmpleadosByEmplId(Long emplId);

}
