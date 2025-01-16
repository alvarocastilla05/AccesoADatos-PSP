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
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<CursoOnline> cursos = new ArrayList<>();

    //Helper

    public void addProducto(CursoOnline c) {
        c.setProfesor(this);
        this.getCursos().add(c);
    }

    public void removeProducto(CursoOnline c) {
        this.getCursos().remove(c);
        c.setProfesor(null);
    }


}
