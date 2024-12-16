package com.example.apartado1;

import java.util.List;

public record AlumnoDto (
        String nombre,
        String apellidos,
        String email,
        Curso curso,
        Direccion direccion
){
    public static AlumnoDto toDto(Alumno alumno){
        String apellidos = alumno.getApellido1() + " " + alumno.getApellido2();
        return new AlumnoDto(
                alumno.getNombre(),
                apellidos,
                alumno.getEmail(),
                alumno.getCurso(),
                alumno.getDireccion()
        );
    }


}