package com.salesianostriana.dam.estructurarutasactualizado.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductoDTO {

    private String nombre;
    private float precio;
    private Long categoriaId;
}
