package com.example.restoservapi.controller;
import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.DetalleOrden;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.model.Producto;
import com.example.restoservapi.service.OrdenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase controlador de Ordenes
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/ordenes")
public class OrdenRestController {
    private final OrdenService ordenService;

    /**
     * Constructor de la clase
     * @param ordenService
     */
    @Autowired
    public OrdenRestController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    /**
     * Método que obtiene todas las ordenes
     * @return Lista de ordenes
     */
    @GetMapping("")
    public ResponseEntity<List<Orden>> getAllOrdenes() {
        return ordenService.getAllOrdenes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Método que obtiene todas las ordenes no hechas
     * @return Lista de ordenes no hechas
     */
    @GetMapping("/undone")
    public ResponseEntity<List<Orden>> getOrdenesByHecho() {
        List<Orden> ordenes = ordenService.findOrdenByHecho(false);
        List<Orden> ordenesFiltradas = new ArrayList<>();

        /**
         * Filtra las ordenes que no tengan productos de la categoria 2
         */
        for (Orden orden : ordenes) {
            List<DetalleOrden> detallesOrdenFiltrados = new ArrayList<>();
            for(DetalleOrden detalleOrden : orden.getDetallesOrden()) {
                Producto prod = detalleOrden.getProducto();
                Long catID = prod.getCategoria().getCatId();
                if(catID != 2) {
                    detallesOrdenFiltrados.add(detalleOrden);
                }
            }
            /**
             * Si la orden tiene detalles, se añade a la lista de ordenes filtradas
             */
            if (!detallesOrdenFiltrados.isEmpty()) {
                Orden ordenFiltrada = new Orden();
                // Copia las propiedades de la orden original a la orden filtrada
                BeanUtils.copyProperties(orden, ordenFiltrada);
                // Establece los detalles de la orden filtrados
                ordenFiltrada.setDetallesOrden(detallesOrdenFiltrados);
                ordenesFiltradas.add(ordenFiltrada);
            }
        }
        return ResponseEntity.ok(ordenesFiltradas);
    }

    /**
     *  Método que obtiene una orden por su id
     * @param ordenId
     * @return orden
     */
    @GetMapping("/{ordenId}")
    public ResponseEntity<Orden> getOrdenesById(@PathVariable Long ordenId) {
        Orden orden = ordenService.getOrdenesById(ordenId);
        if (orden == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orden);
        }
    }

    /**
     * Método que crea una orden
     * @param orden
     * @return orden
     */
   @PostMapping("/createOrder")
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<OrdenDTO> create(@RequestBody Orden orden) {
    if(orden.getOrdenId()!= null){
        return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(ordenService.saveOrden(orden));
   }

    /**
     * Método que actualiza una orden
     * @param ordenId
     * @param orden
     * @return orden
     */
   @PutMapping("/updateOrder/{ordenId}")
    public ResponseEntity<Orden> updateOrder(@PathVariable Long ordenId, @RequestBody Orden orden) {

       if (ordenId == null) {
           return ResponseEntity.badRequest().build();
       }
       Orden ordenExistente = this.ordenService.getOrdenesById(ordenId);
       if (ordenExistente == null) {
           return ResponseEntity.notFound().build();
       }
       ordenExistente.setHecho(orden.getHecho());
       return ResponseEntity.ok(ordenService.updateOrden(ordenExistente));
   }

    /**
     * Método que elimina una orden
     * @param ordenId
     * @return orden
     */
   @DeleteMapping("/deleteOrder/{ordenId}")
    public ResponseEntity<Orden> deleteOrderById(@PathVariable Long ordenId) {
        if (ordenId == null) {
            return ResponseEntity.badRequest().build();
        }
    ordenService.deleteOrdenesById(ordenId);
    return ResponseEntity.noContent().build();
   }

}
