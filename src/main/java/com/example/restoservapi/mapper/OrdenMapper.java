package com.example.restoservapi.mapper;

import com.example.restoservapi.DTO.OrdenDTO;
import com.example.restoservapi.model.Orden;

public class OrdenMapper {
    public static OrdenDTO toOrdenDTO(Orden orden) {
        return OrdenDTO.builder()
                .ordenId(orden.getOrdenId())
                .emplId(orden.getEmpleado().getEmplId())
                .telf(orden.getCliente().getTelf())
                .precioTotal(orden.getPrecioTotal())
                .build();
    }
}
