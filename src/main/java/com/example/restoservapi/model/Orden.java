package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDENES")
public class Orden {

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

    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detallesOrden;

    public void addDetalleOrden(DetalleOrden detalleOrden) {
        detalleOrden.setOrden(this);
        this.detallesOrden.add(detalleOrden);
    }

    public void setPrecioTotal() {
        float total = 0;
        for (DetalleOrden detalle : this.detallesOrden) {
            total += detalle.getProducto().getPrecio();
        }
        this.precioTotal = total;
    }
}
