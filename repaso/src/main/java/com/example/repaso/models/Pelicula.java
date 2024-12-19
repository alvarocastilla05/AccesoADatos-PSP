package com.example.repaso.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {

    private long id;
    private String titulo;
    private String director;
    private String descripcion;
    private List<String> actores;
    private double duracion;
}
