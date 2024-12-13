package com.example.apartado2;

import java.util.List;

public record ProductoDto (
        String nombre,
        double pvp,
        String imagenes,
        String categoria
){

    public static ProductoDto toProducto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().get(0),
                producto.getCategoria().getNombre()
        );
    }
}
