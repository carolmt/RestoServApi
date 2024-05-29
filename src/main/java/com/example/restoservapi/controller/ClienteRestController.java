package com.example.restoservapi.controller;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Clase controlador de Clientes
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RestoServ/api/clientes")
public class ClienteRestController {
    private final ClienteService clienteService;

    /***************************************************************************************************************
     * Constructor de la clase ClienteRestController
     * @param clienteService
     */
    @Autowired
    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /***************************************************************************************************************
     * Método que devuelve todos los clientes
     * @return una ResponseEntity con la lista de clientes
     */
    @GetMapping("")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return clienteService.getAllClientes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /***************************************************************************************************************
     * Método que devuelve un cliente por su telf
     * @param telf
     * @return una ResponseEntity con el objeto cliente
     */
    @GetMapping("/{telf}")
    public ResponseEntity<Cliente> getClienteByTelf(@PathVariable Long telf) {
        return this.clienteService.getClienteByTelf(telf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /***************************************************************************************************************
     * Método que crea un cliente
     * @param cliente
     * @return Una ResponseEntity con el objeto cliente creado
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        if (cliente.getTelf() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    /***************************************************************************************************************
     * Método que actualiza un cliente
     * @param cliente
     * @return una ResponseEntity con el cliente actualizado
     */
    @PutMapping("")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        if (cliente == null || cliente.getTelf() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

    /***************************************************************************************************************
     * Método que elimina un cliente por su telf
     * @param telf
     * @return una ResponseEntity vacia
     */
    @DeleteMapping("/{telf}")
    public ResponseEntity<Cliente> deleteByTelf(@PathVariable Long telf) {
        if (telf == null ) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.deleteClienteByTelf(telf);
        return ResponseEntity.noContent().build();

    }

}
