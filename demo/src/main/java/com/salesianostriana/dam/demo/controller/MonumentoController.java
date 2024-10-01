package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.models.Monumento;
import com.salesianostriana.dam.demo.services.MonumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoServicio monumentoServicio;

    @GetMapping
    public List<Monumento> getMonumentos() {
        return monumentoServicio.findAll();

    }

    /*
    @PostMapping
    public void saveUpdate(@RequestBody Monumento monumento ) {

        monumentoServicio.saveOrUpdate(monumento);
    }*/

    /*@PostMapping
    public ResponseEntity<Monumento> addMonumento(@RequestBody Monumento monumento) {
        Monumento monumentoNuevo = monumentoServicio.saveOrUpdate(monumento);
    }*/

    @PutMapping("{monumentoId}")
    public ResponseEntity<Monumento> editarMonumento(@PathVariable Long monumentoId, @RequestBody Monumento monumento) {
        Optional<Monumento> monumentoEditar = monumentoServicio.findById(monumentoId);

        if (monumentoEditar.isPresent()) {

            monumentoServicio.modificar(monumentoId, monumento);


        }
        return ResponseEntity.ok(monumentoEditar.get());
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
