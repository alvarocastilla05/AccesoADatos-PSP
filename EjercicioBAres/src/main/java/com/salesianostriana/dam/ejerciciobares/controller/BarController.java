package com.salesianostriana.dam.ejerciciobares.controller;

import com.salesianostriana.dam.ejerciciobares.models.Bar;
import com.salesianostriana.dam.ejerciciobares.models.Tag;
import com.salesianostriana.dam.ejerciciobares.services.BarService;
import com.salesianostriana.dam.ejerciciobares.services.TagService;
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
    @Autowired
    private TagService tagService;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarBar(@PathVariable Long id) {
        barService.eliminarBar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> getBarById(@PathVariable Long id) {

        if(barService.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bar>(barService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}/tag/add/{idNuevoTag}")
    public ResponseEntity<Bar> addTag(@PathVariable("id") Long id, @PathVariable("idNuevoTag") Long idNuevoTag) {
        Tag tagNuevo = tagService.findById(idNuevoTag).get();
        return new ResponseEntity<Bar>(barService.aniadirTag(id, tagNuevo), HttpStatus.OK);
    }

    @PutMapping("/{id}/tag/del/{idTag}")
    public ResponseEntity<Bar> delTag(@PathVariable("id") Long id, @PathVariable("idTag") Long idTag) {
        Tag tag = tagService.findById(idTag).get();
        return new ResponseEntity<Bar>(barService.borrarTagDeBar(id, tag), HttpStatus.OK);
    }
}
