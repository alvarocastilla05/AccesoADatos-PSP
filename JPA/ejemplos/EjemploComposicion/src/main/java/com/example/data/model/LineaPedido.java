package com.example.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(LineaPedidoId.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    private double precioVenta;

    @Id
    @ManyToOne
    private Pedido pedido;


}
