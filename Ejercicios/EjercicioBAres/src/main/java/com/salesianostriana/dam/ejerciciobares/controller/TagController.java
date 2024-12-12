package com.salesianostriana.dam.ejerciciobares.controller;

import com.salesianostriana.dam.ejerciciobares.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/place")
public class TagController {

    @Autowired
    private TagService tagService;
}
