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

    /***************************************************************************************************************
     * Atributos de la clase
     ***************************************************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long ordenId; //

    private Date FECHAORDEN = new Date();
    @Column(name = "precio_total")
    private float precioTotal; //
    private Boolean hecho = false;

    @ManyToOne
    @JoinColumn(name = "telf") //
    @JsonIgnoreProperties("ordenCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empl_id") //
    @JsonIgnoreProperties("ordenes")
    private Empleado empleado;

    @JsonManagedReference
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detallesOrden;

    public void setPrecioTotal() {
        float total = 0;
        for (DetalleOrden detalle : this.detallesOrden) {
            total += detalle.getProducto().getPrecio();
        }
        this.precioTotal = total;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal + detallesOrden.stream().map(DetalleOrden::getPrecioProducto).reduce(0.0f, Float::sum);
    }

    public void addDetalleOrden(DetalleOrden detalleOrden) {
        detalleOrden.setOrden(this);
        this.detallesOrden.add(detalleOrden);
        this.precioTotal += detalleOrden.getPrecioProducto();
    }
}
