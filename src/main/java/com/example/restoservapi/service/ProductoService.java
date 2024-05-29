package com.example.restoservapi.service;

import com.example.restoservapi.model.Producto;

import java.util.List;
import java.util.Optional;

/***************************************************************************************************************
 * Autor: Carolina Maldonado Torres
 * Curso: 2DAM - IES Alvaro Falomir 2022-2024
 * Descripción: Interfaz que define los métodos que se implementarán en la clase ProductoServiceImpl.
 * Estos métodos se utilizan para realizar operaciones CRUD sobre la tabla Producto de la base de datos.
 ***************************************************************************************************************/
public interface ProductoService {
    Optional<Producto> getProductoByProdID(Long prodId);
    Optional<Producto> getProductosByNomProdIgnoreCase(String nomProd);
    List<Producto> getAllProductos();
}
