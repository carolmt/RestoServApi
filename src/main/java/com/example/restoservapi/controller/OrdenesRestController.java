package com.example.restoservapi.controller;

import com.example.restoservapi.model.Ordenes;
import com.example.restoservapi.service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RestoServ/api/ordenes")
public class OrdenesRestController {
    private final OrdenesService ordenesService;

    @Autowired
    public OrdenesRestController(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }

    @GetMapping("")
    public ResponseEntity<List<Ordenes>> getAllOrdenes() {
        return ordenesService.getAllOrdenes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{ordenId}")
    public ResponseEntity<Ordenes> getOrdenesById(Long ordenId) {
        return ordenesService.getOrdenesById(ordenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ordenes> create(@RequestBody Ordenes orden) {
        if (orden.getOrdenId() != null)
            return ResponseEntity.badRequest().build();

        if (orden.getEmpleado() == null || orden.getEmpleado().getEmplId() == null ||
                orden.getCliente() == null || orden.getCliente().getTelf() == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ordenesService.saveOrdenes(orden));
    }
}
