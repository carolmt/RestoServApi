package com.example.restoservapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CLIENTES")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telf;

    private String nom_cli;
    private String direccion;
    private String comentario;

    @OneToOne(mappedBy = "cliente")
    private Ordenes orden;

}
