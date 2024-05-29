package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * Clase que representa la entidad Producto en la base de datos.
 * La clase Producto tiene una relación de muchos a uno con la entidad Categoria.
 * La clase Producto tiene una relación de uno a muchos con la entidad DetalleOrden.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long prodId;
    @Column(name = "nom_prod")
    private String nomProd;
    private float precio;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<DetalleOrden> detallesOrden;
}
