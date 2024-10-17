package com.salesianostriana.dam.estructurarutasactualizado.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}