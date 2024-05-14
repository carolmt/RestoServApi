package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="ORDENES")
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long ordenId;

    private Date FECHAORDEN;
    @Column(name = "precio_total")
    private float precioTotal;
    private Boolean hecho;

    @OneToOne
    @JoinColumn(name = "telf")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "empl_id")
    @JsonIgnoreProperties("ORDENES")
    private Empleados empleado;

    @OneToMany(mappedBy = "orden")
    private Set<Detalle_Ordenes> detallesOrden;

}
