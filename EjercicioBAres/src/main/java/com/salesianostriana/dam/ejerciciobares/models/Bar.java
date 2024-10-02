package com.salesianostriana.dam.ejerciciobares.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private String descripcion;

    /*
    @Column(nullable = false)
    private List<String> tags = new ArrayList<>();
    */
}
