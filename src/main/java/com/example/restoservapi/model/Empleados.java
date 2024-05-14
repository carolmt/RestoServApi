package com.example.restoservapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLEADOS")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empl_id")
    private Long emplId;

    private int codigo;
    private String nom_empl;
    private String apellido_empl;

    @OneToMany(mappedBy = "empleado")
    private List<Ordenes> ordenes;



























}
