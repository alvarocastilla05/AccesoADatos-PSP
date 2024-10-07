package com.salesianostriana.dam.ejercicio1dtos.services;

import com.salesianostriana.dam.ejercicio1dtos.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
}
