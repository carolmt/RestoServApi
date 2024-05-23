package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DETALLE_ORDENES")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long detalleId;

    @Column(name = "orden_id", insertable = false, updatable = false)
    private Long ordenId;

    @Column(name = "prod_id", insertable = false, updatable = false)
    private Long prodId;

    @Column(name = "CANTIDAD")
    private int cantidad = 1;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    @JsonIgnoreProperties("detallesOrden")
    Orden orden;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    @JsonIgnoreProperties("detallesOrden")
    Producto producto;
}
