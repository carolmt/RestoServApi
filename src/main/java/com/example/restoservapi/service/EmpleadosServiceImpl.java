package com.example.restoservapi.service;

import com.example.restoservapi.model.Empleados;
import com.example.restoservapi.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosServiceImpl implements EmpleadosService{
    private final EmpleadosRepository empleadosRepository;

    @Autowired
    public EmpleadosServiceImpl(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadosRepository.findAll();
    }


    @Override
    public Optional<Empleados> getEmpleadosByEmplId(Long emplId) {
        return empleadosRepository.findEmpleadosByEmplId(emplId);
    }
}
