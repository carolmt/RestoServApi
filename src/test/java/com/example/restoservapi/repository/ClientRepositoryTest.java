package com.example.restoservapi.repository;

import com.example.restoservapi.model.Cliente;
import com.example.restoservapi.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ClientRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;
    Cliente client;
    Cliente client2;

    @BeforeEach
    void setUp() {
        client = Cliente.builder().telf(123456789L).nom_cli("Juan").direccion("Calle 1").comentario("Comentario").build();
        client2 = Cliente.builder().telf(987654321L).nom_cli("Pedro").direccion("Calle 2").comentario("Comentario").build();
    }

    @Test
    void shouldSaveAndFetchClient() {
        clienteRepository.save(client);
        assertTrue(clienteRepository.findById(client.getTelf()).isPresent());
        assertEquals(client, clienteRepository.findById(client.getTelf()).get());
    }
}
