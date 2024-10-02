package com.salesianostriana.dam.ejerciciobares.controller;

import com.salesianostriana.dam.ejerciciobares.models.Bar;
import com.salesianostriana.dam.ejerciciobares.services.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/place")
public class BarController {

    @Autowired
    private BarService barService;

    @GetMapping
    public ResponseEntity<List<Bar>> getAllBars() {
        return new ResponseEntity<>(barService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bar> addBar(@RequestBody Bar bar) {
        return new ResponseEntity<Bar>(barService.guardarBar(bar), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Bar> modificarBar(@RequestBody Bar bar, @PathVariable Long id){
        return new ResponseEntity<Bar>(barService.modificar(id, bar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarBar(@PathVariable Long id) {
        barService.eliminarBar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Bar> getBarById(@PathVariable Long id) {

        if(barService.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bar>(barService.findById(id).get(), HttpStatus.OK);
    }
}
