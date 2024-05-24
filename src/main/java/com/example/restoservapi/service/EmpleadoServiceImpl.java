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

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }


    @Override
    public Optional<Empleado> getEmpleadosByEmplId(Long emplId) {
        return empleadoRepository.findEmpleadosByEmplId(emplId);
    }

    @Override
    public Optional<Empleado> getEmpleadoByCodigo(int codigo) {
        return empleadoRepository.findEmpleadosByCodigo(codigo);
    }

    @Override
    public Optional<Empleado> getEmpleadoByCodigoAndNomEmpl(int codigo, String nomEmpl) {
        return empleadoRepository.findEmpleadoByCodigoAndNomEmpl(codigo, nomEmpl);
    }
}
