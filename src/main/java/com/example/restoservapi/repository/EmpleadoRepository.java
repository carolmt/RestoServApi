package com.example.restoservapi.repository;

import com.example.restoservapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface que extiende de JpaRepository para realizar operaciones CRUD sobre la entidad Empleado.
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    Optional<Empleado> findEmpleadosByEmplId(Long emplId);
    Optional<Empleado> findEmpleadosByCodigo(int codigo);
    Optional<Empleado> findEmpleadoByCodigoAndNomEmpl(int codigo, String nomEmpl);

}
