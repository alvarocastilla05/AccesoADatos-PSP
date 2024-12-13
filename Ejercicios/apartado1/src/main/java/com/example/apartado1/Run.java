package com.example.apartado1;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Run {

    @PostConstruct
    public void init() {
        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Calle")
                .linea1("Linea1")
                .linea2("Linea2")
                .cp("12345")
                .poblacion("Ciudad")
                .provincia("Provincia")
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("DAM")
                .tipo("Informatica")
                .tutor("Luismi")
                .aula("Aula 200")
                .build();

        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Álvaro")
                .apellido1("Castilla")
                .apellido2("Cano")
                .email("alvarocasno06@gmail.com")
                .curso(curso)
                .direccion(direccion)
                .build();

        AlumnoDto alumnoDto = AlumnoDto.toDto(alumno);

        System.out.println(alumnoDto);
    }
}
