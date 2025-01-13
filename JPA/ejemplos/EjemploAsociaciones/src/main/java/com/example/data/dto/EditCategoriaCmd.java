package com.example.data.dto;

import com.example.data.model.Producto;

import java.util.List;

public record EditCategoriaCmd(
        String nombre,
        List<Producto> productos
) {
}
