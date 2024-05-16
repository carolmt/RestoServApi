package com.example.restoservapi.controller;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{ordenId}")
    public ResponseEntity<Orden> getOrdenesById(Long ordenId) {
        return ordenService.getOrdenesById(ordenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @PostMapping("/createOrder")
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<OrdenDTO> create(@RequestBody Orden orden) {
    if(orden.getOrdenId()!= null){
        return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(ordenService.saveOrdenes(orden));
   }


    /*@PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrdenDTO> create (@RequestBody OrdenDTO orden){
        return ResponseEntity.ok(ordenService.saveOrdenes(orden));

    }*/
}
