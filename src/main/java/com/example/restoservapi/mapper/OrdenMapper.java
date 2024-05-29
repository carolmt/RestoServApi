package com.example.restoservapi.mapper;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Orden;

/**
 * Clase que se encarga de mapear una entidad Orden a un DTO OrdenDTO.
 */
public class OrdenMapper {

    /**
     * Método que mapea una entidad Orden a un DTO OrdenDTO.
     * @param orden Entidad Orden.
     * @return DTO OrdenDTO.
     */
    public static OrdenDTO toOrdenDTO(Orden orden) {
        return OrdenDTO.builder()
                .ordenId(orden.getOrdenId())
                .emplId(orden.getEmpleado().getEmplId())
                .telf(orden.getCliente().getTelf())
                .precioTotal(orden.getPrecioTotal())
                .build();
    }
}
