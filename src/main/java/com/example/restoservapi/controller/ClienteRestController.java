package com.example.restoservapi.controller;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RestoServ/api/clientes")
public class ClienteRestController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return clienteService.getAllClientes()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{telf}")
    public ResponseEntity<Cliente> getClienteByTelf(@PathVariable Long telf) {
        return this.clienteService.getClienteByTelf(telf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        if (cliente.getTelf() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @PutMapping("")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        if (cliente == null || cliente.getTelf() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

}
