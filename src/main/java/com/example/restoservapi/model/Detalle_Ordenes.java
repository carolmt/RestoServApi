package com.example.restoservapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DETALLE_ORDENES")
public class Detalle_Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long detalleId;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    Ordenes orden;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    Productos producto;
}
