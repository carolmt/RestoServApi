package com.example.restoservapi.DTO;

import lombok.Builder;

@Builder
public record OrdenDTO (
        Long ordenId,
        Long emplId,
        Long telf,
        double precioTotal
)
{ }
