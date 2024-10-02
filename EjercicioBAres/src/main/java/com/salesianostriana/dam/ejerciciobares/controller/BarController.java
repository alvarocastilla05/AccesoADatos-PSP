package com.salesianostriana.dam.ejerciciobares.controller;

import com.salesianostriana.dam.ejerciciobares.services.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/bares")
public class BarController {

    @Autowired
    private BarService barService;
}
