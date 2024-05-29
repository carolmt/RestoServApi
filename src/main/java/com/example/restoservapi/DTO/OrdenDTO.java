package com.example.restoservapi.DTO;

import lombok.Builder;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) de una orden.
 * @param ordenId
 * @param emplId
 * @param telf
 * @param precioTotal
 */
@Builder
public record OrdenDTO (
        Long ordenId,
        Long emplId,
        Long telf,
        double precioTotal
)
{ }
