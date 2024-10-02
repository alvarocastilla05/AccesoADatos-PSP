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
    private String codPais;

    @Column(nullable = false)
    private String nombrePais;

    @Column(nullable = false)

    private String nombreCiudad;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private String nombreMonumento;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String urlFoto;



}
