package com.salesianostriana.dam.ejercicio1dtos.repositories;

import com.salesianostriana.dam.ejercicio1dtos.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
