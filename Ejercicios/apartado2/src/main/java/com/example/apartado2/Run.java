package com.example.apartado2;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Run {
    @PostConstruct
    public void init(){

        Categoria categoria = new Categoria(1L, "Reacondicionado");

        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Movil")
                .descripcion("Chulo chulo")
                .pvp(699.99)
                .imagenes(Arrays.asList("imagen1.png", "imagen2.png"))
                .categoria(categoria)
                .build();

        ProductoDto productoDto = ProductoDto.toProducto(producto);

        System.out.println(productoDto);
    }
}
