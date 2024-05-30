package com.example.restoservapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que representa la entidad Cliente en la base de datos.
 * Se mapea a la tabla CLIENTES.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CLIENTES")
public class Cliente {
    @Id
    private Long telf;

    private String nom_cli;
    private String direccion;
    private String comentario;

    /**
     * Relación uno a muchos con la entidad Orden.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Orden> ordenCliente;

}
