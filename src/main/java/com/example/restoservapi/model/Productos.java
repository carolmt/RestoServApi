package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCTOS")
public class Productos {
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
    private Categorias categoria;

    @OneToMany(mappedBy = "producto")
    private Set<Detalle_Ordenes> detallesOrden;
}
