package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.model.Orden;
import com.example.restoservapi.repository.ClienteRepository;
import com.example.restoservapi.repository.DetalleOrdenRepository;
import com.example.restoservapi.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase Servicio que implementa los métodos de la interfaz ClienteService
 ***************************************************************************************************************/
@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final OrdenRepository ordenRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;

    /**
     * Constructor de la clase ClienteServiceImpl
     * @param clienteRepository
     * @param ordenRepository
     * @param detalleOrdenRepository
     */
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, OrdenRepository ordenRepository, DetalleOrdenRepository detalleOrdenRepository) {
        this.clienteRepository = clienteRepository;
        this.ordenRepository = ordenRepository;
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    /**
     * Método que devuelve un cliente por su teléfono
     * @param telf
     * @return cliente
     */
    @Override
    public Optional<Cliente> getClienteByTelf(Long telf) {
        return clienteRepository.findClienteByTelf(telf);
    }

    /**
     * Método que devuelve una lista de clientes
     * @return lista de clientes
     */
    @Override
    public Optional<List<Cliente>> getAllClientes() {
        return Optional.of(clienteRepository.findAll());
    }

    /**
     * Método que elimina un cliente por su teléfono
     * @param telf
     */
    @Transactional
    @Override
    public void deleteClienteByTelf(Long telf) {
        Optional<Cliente> cliente = clienteRepository.findClienteByTelf(telf);
        /**
         * Si el cliente existe, se eliminan todas las ordenes asociadas a ese cliente
         */
        if (cliente.isPresent()) {
            List<Orden> ordenes = ordenRepository.findByCliente(cliente.get());
            /**
             * Se eliminan los detalles de orden asociados a cada orden
             */
            for (Orden orden : ordenes) {
                detalleOrdenRepository.deleteByOrden(orden);
                ordenRepository.delete(orden);
            }
            clienteRepository.delete(cliente.get());
        }
    }

    /**
     * Método que guarda un cliente
     * @param cliente
     * @return cliente
     */
    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Método que actualiza un cliente
     * @param cliente
     * @return cliente
     */
    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
