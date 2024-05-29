package com.example.restoservapi.controller;

import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Controlador que gestiona las peticiones HTTP relacionadas con la tabla DetalleOrden de la base de datos.
 ***************************************************************************************************************/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/detalleOrdenes")
public class DetalleOrdenRestController {
    private final DetalleOrdenService detalleOrdenService;

    /***************************************************************************************************************
     * Descripción: Constructor que inyecta la dependencia del servicio de DetalleOrden.
     * @param detalleOrdenService
     ***************************************************************************************************************/
    @Autowired
    public DetalleOrdenRestController(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    /***************************************************************************************************************
     * Descripción: Método que devuelve una lista con todos los detalles de las órdenes.
     * @return lista de detalles de orden
     ***************************************************************************************************************/

    @GetMapping("")
    public List<DetalleOrden> getAllDetalleOrden() {
        return detalleOrdenService.getAllDetalleOrden();
    }

    /***************************************************************************************************************
     * Descripción: Método que devuelve un detalle de orden por su id.
     * @param detalleId
     * @return una ResponseEntity con el detalle de orden
     ***************************************************************************************************************/
    @GetMapping("/{detalleId}")
    public ResponseEntity<DetalleOrden> getDetalleOrdenById(Long detalleId) {
        return this.detalleOrdenService.getDetalleOrdenById(detalleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /***************************************************************************************************************
     * Descripción: Método que crea un detalle de orden.
     * @param detalleOrden
     * @return una ResponseEntity que contiene un objeto DetalleOrden
     ***************************************************************************************************************/
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetalleOrden> create(@RequestBody DetalleOrden detalleOrden) {
        if(detalleOrden.getDetalleId() != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(detalleOrdenService.saveDetalleOrden(detalleOrden));
    }
}
