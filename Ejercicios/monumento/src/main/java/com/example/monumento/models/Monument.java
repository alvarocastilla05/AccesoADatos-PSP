package com.example.monumento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cod_pais;

    private String nombre;

    private String nombre_ciudad;

    private double latitud;

    private double longitud;

    private String nombre_monumento;

    private String descripcion;

    private String url_foto;
}
