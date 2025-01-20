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
    public void init() {

        Categoria c = Categoria.builder()
                .nombre("Alimentación")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Bollería")
                .categoriaPadre(c)
                .build();

        Categoria c3 = Categoria.builder()
                .nombre("Electrónica")
                .build();

        categoriaRepository.save(c);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);

        Producto p = Producto.builder()
                .nombre("Napolitana")
                .precioVenta(2.30)
                .categoria(c)
                .build();

        productoRepository.save(p);

        categoriaRepository.delete(c);

    }
}