package com.example.restoservapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que representa la entidad Categoria en la base de datos.
 * La clase es una entidad JPA y se mapea a la tabla CATEGORIAS.
 * La clase contiene los atributos de la tabla y las relaciones con otras entidades.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CATEGORIAS")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long catId;

    @Column(name = "nom_cat")
    private String nomCat;

    /**
     * Relación uno a muchos con la entidad Producto.
     * La relación es bidireccional y se mapea con la columna cat_id de la tabla PRODUCTOS.
     * La relación es de uno a muchos, ya que una categoría puede tener varios productos.
     * La relación es de tipo LAZY, ya que no se necesita cargar los productos de una categoría
     * a menos que se acceda a ellos.
     */
    @OneToMany(mappedBy = "categoria",
    cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Producto> productos;
}
