package com.example.Apartado2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id",
            foreignKey = @ForeignKey(name = "fk_cursoOnline_profesor")
    )
    private Profesor profesor;
}
