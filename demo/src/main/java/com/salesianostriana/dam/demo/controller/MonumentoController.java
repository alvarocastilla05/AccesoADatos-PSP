package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.models.Monumento;
import com.salesianostriana.dam.demo.services.MonumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoServicio monumentoServicio;

    @GetMapping
    public List<Monumento> getMonumentos() {
        return monumentoServicio.findAll();

    }

    @PostMapping
    public void saveUpdate(@RequestBody Monumento monumento ) {
        monumentoServicio.saveOrUpdate(monumento);
    }

    @DeleteMapping("{monumentoId}")
    public void deleteMonumento(@PathVariable("monumentoId") Long monumentoId) {
        monumentoServicio.delete(monumentoId);
    }

    @GetMapping("/{monumentoId}")
    public Optional<Monumento> getById(@PathVariable("monumentoId") Long monumentoId) {
        return monumentoServicio.findById(monumentoId);
    }
}
