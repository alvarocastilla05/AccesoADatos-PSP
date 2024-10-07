package com.salesianostriana.dam.ejercicio1dtos.controller;

import com.salesianostriana.dam.ejercicio1dtos.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
}
