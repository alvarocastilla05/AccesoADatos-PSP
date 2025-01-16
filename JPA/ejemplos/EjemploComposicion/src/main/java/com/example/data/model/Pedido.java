package com.example.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String cliente;

    @OneToMany(
            mappedBy = "pedido",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<LineaPedido> lineasPedido = new ArrayList<>();

    //Helpers

    public void addLineaPedido(LineaPedido lineaPedido){
        lineasPedido.add(lineaPedido);
    }
}
