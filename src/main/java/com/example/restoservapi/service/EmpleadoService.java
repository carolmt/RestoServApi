package com.example.restoservapi.service;

import com.example.restoservapi.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Optional<Empleado> getEmpleadosByEmplId(Long emplId);
    List<Empleado> getAllEmpleados();
}
