package com.example.restoservapi.service;

import com.example.restoservapi.model.Empleados;

import java.util.List;
import java.util.Optional;

public interface EmpleadosService {
    Optional<Empleados> getEmpleadosByEmplId(Long emplId);
    List<Empleados> getAllEmpleados();
}
