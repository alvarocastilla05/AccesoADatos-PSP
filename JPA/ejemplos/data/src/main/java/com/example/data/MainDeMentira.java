package com.example.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private ProductoRepository repo;

    @PostConstruct
    public void run(){

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catalogo")
                .precio(123.45)
                .build();

        repo.save(p);
    }
}
