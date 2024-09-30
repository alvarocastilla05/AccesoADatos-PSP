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
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long monumentoIds;

    @Column(nullable = false, length = 2) //Restricciones para el código del país.
   private String cod_pais;

   private String nombre_pais;
   private String nombre_ciudad;
   private double latitud;
   private double longitud;
   private String nombre_monumento;
   private String descripcion;
   private String url_foto;



}
