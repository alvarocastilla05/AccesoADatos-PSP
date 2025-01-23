package com.example.TiposHerencia.mappedSuperClass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Vehiculo {

    @Id
    @GeneratedValue
    private Long id;

    private double precio;

    private String matricula;

    private String marca;

}
