package com.example.TiposHerencia.singleTable.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Coche")
@Setter
@Getter
public class Coche extends Vehiculo {

    private int puertas;
}
