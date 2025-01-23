package com.example.TiposHerencia.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Coche extends Vehiculo{

    private int numeroPuertas;

    private int numPlazas;
}
