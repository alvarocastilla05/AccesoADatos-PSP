package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.models.Monumento;
import com.salesianostriana.dam.demo.services.MonumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Monumento>> getMonumentos() {
        return new ResponseEntity<>(monumentoServicio.findAll(), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Monumento> addMonumento(@RequestBody Monumento monumento) {
        return new ResponseEntity<Monumento>(monumentoServicio.guardarMonumento(monumento), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{monumentoId}")
    public ResponseEntity<Monumento> modificarMonumento(@RequestBody Monumento monumento, @PathVariable Long monumentoId) {
        return new ResponseEntity<Monumento>(monumentoServicio.modificar(monumentoId, monumento), HttpStatus.OK);
    }



    @DeleteMapping("/{monumentoId}")
    public ResponseEntity<?> deleteMonumento(@PathVariable("monumentoId") Long monumentoId) {
        monumentoServicio.delete(monumentoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{monumentoId}")
    public ResponseEntity<Monumento> getById(@PathVariable("monumentoId") Long monumentoId) {

        if(monumentoServicio.findById(monumentoId).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Monumento>(monumentoServicio.findById(monumentoId).get(), HttpStatus.OK);
    }
}
