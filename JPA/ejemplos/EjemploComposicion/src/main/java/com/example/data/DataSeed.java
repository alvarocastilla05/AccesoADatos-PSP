package com.example.data;

import com.example.data.model.Pedido;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.PedidoRepository;
import com.example.data.repos.ProductoRepository;
import com.example.data.repos.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final TagRepository tagRepository;
    private final PedidoRepository pedidoRepository;

    @PostConstruct
    public void run() {

       /* Categoria c = categoriaRepository.getReferenceById(1L);

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

        productoRepository.saveAll(List.of(p, p2));*/

        Pedido pedido = Pedido.builder()
                .cliente("Luismi")
                .build();

        productoRepository
                .findAll()
                .forEach(System.out::println);
    }

}