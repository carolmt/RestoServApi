package com.example.restoservapi.controller;

import com.example.restoservapi.model.Empleados;
import com.example.restoservapi.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RestoServ/api/empleados")
public class EmpleadosRestController {
    private final EmpleadosService empleadosService;

    @Autowired
    public EmpleadosRestController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping("")
    public ResponseEntity<List<Empleados>>getAllEmpleados(){
        return ResponseEntity.ok(empleadosService.getAllEmpleados());
    }

    @GetMapping("/{emplId}")
    public ResponseEntity<Empleados>getEmpleadosByEmplId(@PathVariable Long emplId){
        return this.empleadosService.getEmpleadosByEmplId(emplId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
