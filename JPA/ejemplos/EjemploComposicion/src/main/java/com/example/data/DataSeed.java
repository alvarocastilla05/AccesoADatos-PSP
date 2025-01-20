package com.example.data;

import com.example.data.model.LineaPedido;
import com.example.data.model.Pedido;
import com.example.data.model.Producto;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.PedidoRepository;
import com.example.data.repos.ProductoRepository;
import com.example.data.repos.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

        List<Producto> productos = productoRepository.findAll();

        Pedido pedido = Pedido.builder()
                .cliente("Luismi")
                .build();

        pedido.addLineaPedido(LineaPedido.builder()
                .producto(productos.get(0))
                .cantidad(2)
                .precioVenta(productos.get(0).getPrecio())
                .build());


        pedido.addLineaPedido(LineaPedido.builder()
                .producto(productos.get(1))
                .cantidad(1)
                .precioVenta(productos.get(1).getPrecio())
                .build());


        pedidoRepository.save(pedido);

        pedidoRepository.findAll()
                .forEach(p -> {
                    System.out.println(p.toString());
                    System.out.println(p.getLineasPedido());
                    System.out.println("\n");
                });

        pedidoRepository.deleteById(1L);

    }
}

