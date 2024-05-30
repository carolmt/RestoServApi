package com.example.restoservapi.service;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteServiceImpl clientService;

    Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = Cliente.builder().telf(123456789L).nom_cli("Juan").direccion("Calle 1").comentario("Comentario").build();
    }

    @Test
    public void shouldReturnClientWhenFindByTelf() {
        when(clienteRepository.findClienteByTelf(123456789L)).thenReturn(Optional.of(cliente));
        Optional<Cliente> cliente2 = clientService.getClienteByTelf(123456789L);
        Assertions.assertNotNull(cliente2);
        assertEquals(123456789L, cliente2.get().getTelf());
        verify(clienteRepository).findClienteByTelf(123456789L);
    }
}
