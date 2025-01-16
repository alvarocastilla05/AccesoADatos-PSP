package com.example.Apartado1;

import com.example.Apartado1.model.Categoria;
import com.example.Apartado1.model.Producto;
import com.example.Apartado1.repos.CategoriaRepository;
import com.example.Apartado1.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void run(){

        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p = Producto.builder()
                .nombre("Un producto")
                .precioVenta(123.45)
                .categoria(c)
                .build();

        c.addProducto(p);

        productoRepository.save(p);

        System.out.println("Prodcutos de la categoria 1:");
        System.out.println(c.getProductos());
    }
}
