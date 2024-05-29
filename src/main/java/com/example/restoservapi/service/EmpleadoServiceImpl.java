package com.example.restoservapi.service;

import com.example.restoservapi.model.Empleado;
import com.example.restoservapi.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que implementa los métodos de la interfaz EmpleadoService
 ***************************************************************************************************************/
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    /**
     * Constructor de la clase EmpleadoServiceImpl
     * @param empleadoRepository
     */
    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    /**
     * Método que devuelve una lista de empleados
     * @return lista de empleados
     */
    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    /**
     * Método que devuelve un empleado por su id
     * @param emplId
     * @return empleado
     */
    @Override
    public Optional<Empleado> getEmpleadosByEmplId(Long emplId) {
        return empleadoRepository.findEmpleadosByEmplId(emplId);
    }

    /**
     * Método que devuelve un empleado por su código
     * @param codigo
     * @return empleado
     */
    @Override
    public Optional<Empleado> getEmpleadoByCodigo(int codigo) {
        return empleadoRepository.findEmpleadosByCodigo(codigo);
    }

    /**
     * Método que devuelve un empleado por su código y nombre
     * @param codigo
     * @param nomEmpl
     * @return empleado
     */
    @Override
    public Optional<Empleado> getEmpleadoByCodigoAndNomEmpl(int codigo, String nomEmpl) {
        return empleadoRepository.findEmpleadoByCodigoAndNomEmpl(codigo, nomEmpl);
    }
}
