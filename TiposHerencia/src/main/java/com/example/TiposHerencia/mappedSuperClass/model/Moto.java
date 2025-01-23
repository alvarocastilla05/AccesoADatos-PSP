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
public class Moto extends Vehiculo{

    private int numeroRuedas;

    private boolean casco;
}
