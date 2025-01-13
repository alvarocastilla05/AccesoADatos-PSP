package com.example.data;

import com.example.data.model.Categoria;
import com.example.data.model.Producto;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {

        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                .categoria(c)
                .build();


        productoRepository.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepository.saveAll(List.of(p, p2));


    }

}