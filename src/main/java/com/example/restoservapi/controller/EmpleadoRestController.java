package com.example.restoservapi.controller;

import com.example.restoservapi.model.Empleado;
import com.example.restoservapi.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Empleado>getEmpleadoByCodigo(@PathVariable int codigo) {
        return this.empleadoService.getEmpleadoByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}?{nomEmpl}")
    public ResponseEntity<Empleado>getEmpleadoByCodigoAndNomEmpl(@PathVariable int codigo, String nomEmpl) {
        return this.empleadoService.getEmpleadoByCodigoAndNomEmpl(codigo, nomEmpl)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
