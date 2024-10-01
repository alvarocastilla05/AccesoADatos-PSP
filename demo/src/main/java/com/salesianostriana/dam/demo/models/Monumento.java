package com.salesianostriana.dam.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long monumentoId;

    @Column(nullable = false, length = 2) //Restricciones para el código del país.
    private String cod_pais;

    @Column(nullable = false)
    private String nombre_pais;

    @Column(nullable = false)

    private String nombre_ciudad;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private String nombre_monumento;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String url_foto;



}
