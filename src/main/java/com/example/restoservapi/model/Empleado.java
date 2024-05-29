package com.example.restoservapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que representa la entidad Empleado
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLEADOS")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empl_id")
    private Long emplId;

    private int codigo;
    @Column(name = "nom_empl")
    private String nomEmpl;
    @Column(name = "apellido_empl")
    private String apellidoEmpl;

    /**
     * Relación uno a muchos con la entidad Orden
     */
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL)
    private List<Orden> ordenes;

}
