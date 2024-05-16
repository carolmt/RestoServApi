package com.example.restoservapi.controller;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/detalleOrdenes")
public class DetalleOrdenRestController {
    private final DetalleOrdenService detalleOrdenService;

    @Autowired
    public DetalleOrdenRestController(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    @GetMapping("")
    public ResponseEntity<List<DetalleOrden>> getAllDetalleOrden() {
        return detalleOrdenService.getAllDetalleOrden()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{detalleId}")
    public ResponseEntity<DetalleOrden> getDetalleOrdenById(Long detalleId) {
        return this.detalleOrdenService.getDetalleOrdenById(detalleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetalleOrden> create(@RequestBody DetalleOrden detalleOrden) {
        return ResponseEntity.ok(detalleOrdenService.saveDetalleOrden(detalleOrden));
    }
}
