package com.example.TiposHerencia.singleTable.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Verdura {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double precio;

    private LocalDate caducidad;
}
