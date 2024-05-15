package com.example.restoservapi.controller;

import com.example.restoservapi.model.Empleado;
import com.example.restoservapi.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RestoServ/api/empleados")
public class EmpleadoRestController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoRestController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Empleado>>getAllEmpleados(){
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }

    @GetMapping("/{emplId}")
    public ResponseEntity<Empleado>getEmpleadosByEmplId(@PathVariable Long emplId){
        return this.empleadoService.getEmpleadosByEmplId(emplId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
