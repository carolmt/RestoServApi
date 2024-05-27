package com.example.restoservapi.controller;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Clase controlador de Ordenes
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/ordenes")
public class OrdenRestController {
    private final OrdenService ordenService;

    @Autowired
    public OrdenRestController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping("")
    public ResponseEntity<List<Orden>> getAllOrdenes() {
        return ordenService.getAllOrdenes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/undone")
    public ResponseEntity<List<Orden>> getOrdenesByHecho() {
        return ResponseEntity.ok(ordenService.findOrdenByHecho(false));
    }

    @GetMapping("/{ordenId}")
    public ResponseEntity<Orden> getOrdenesById(@PathVariable Long ordenId) {
        Orden orden = ordenService.getOrdenesById(ordenId);
        if (orden == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orden);
        }
    }

   @PostMapping("/createOrder")
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<OrdenDTO> create(@RequestBody Orden orden) {
    if(orden.getOrdenId()!= null){
        return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(ordenService.saveOrden(orden));
   }

   @PutMapping("/updateOrder")
    public ResponseEntity<OrdenDTO> updateOrder(@RequestBody Orden orden) {
     if(orden.getOrdenId() != null){
          return ResponseEntity.badRequest().build();
     }
     return ResponseEntity.ok(ordenService.updateOrdenes(orden));
    }

   @DeleteMapping("/deleteOrder/{ordenId}")
    public ResponseEntity<Orden> deleteOrderById(@PathVariable Long ordenId) {
        if (ordenId == null) {
            return ResponseEntity.badRequest().build();
        }
    ordenService.deleteOrdenesById(ordenId);
    return ResponseEntity.noContent().build();
   }

}
