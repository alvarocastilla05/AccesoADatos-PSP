package com.example.TiposHerencia.singleTable.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehiculo {

    @Id
    @GeneratedValue
    private Long id;

    private String marca;

    private String modelo;

}
