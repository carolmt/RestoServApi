package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Clase que representa la entidad Orden
 ***************************************************************************************************************/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDENES")
public class Orden {
    /**
     * * Clase que representa la entidad Orden en la base de datos.
     * * La clase es una entidad JPA y se mapea a la tabla ORDENES.
     * * La clase contiene los atributos de la tabla y las relaciones con otras entidades.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long ordenId; //

    private Date FECHAORDEN = new Date();
    @Column(name = "precio_total")
    private float precioTotal; //
    private Boolean hecho = false;

    /**
     * * Relación muchos a uno con la entidad Cliente.
     * * La relación es unidireccional
     */
    @ManyToOne
    @JoinColumn(name = "telf") //
    @JsonIgnoreProperties("ordenCliente")
    private Cliente cliente;

    /**
     * * Relación muchos a uno con la entidad Empleado.
     * * La relación es unidireccional
     */
    @ManyToOne
    @JoinColumn(name = "empl_id") //
    @JsonIgnoreProperties("ordenes")
    private Empleado empleado;

    /**
     * * Relación uno a muchos con la entidad DetalleOrden.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detallesOrden;

    public void addDetalleOrden(DetalleOrden detalleOrden) {
        detalleOrden.setOrden(this);
        this.detallesOrden.add(detalleOrden);
        this.precioTotal += detalleOrden.getPrecioProducto();
    }
}
