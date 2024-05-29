package com.example.restoservapi.service;

import com.example.restoservapi.model.Empleado;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Interfaz que define los métodos que se implementarán en la clase EmpleadosServiceImpl.
 * Estos métodos se utilizan para realizar operaciones CRUD sobre la tabla Empleados de la base de datos.
 ***************************************************************************************************************/
public interface EmpleadoService {
    Optional<Empleado> getEmpleadosByEmplId(Long emplId);
    List<Empleado> getAllEmpleados();
    Optional<Empleado> getEmpleadoByCodigo(int codigo);
    Optional<Empleado> getEmpleadoByCodigoAndNomEmpl(int codigo, String nomEmpl);
}
