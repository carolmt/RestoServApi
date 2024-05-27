package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que representa la entidad DetalleOrden
 ***************************************************************************************************************/
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "orden_id")
    @JsonIgnoreProperties("detallesOrden")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    @JsonIgnoreProperties("detallesOrden")
    Producto producto;

    public float getPrecioProducto() {
        return this.producto.getPrecio();
    }
}
