package com.example.repaso.controllers;

import com.example.repaso.models.Pelicula;
import com.example.repaso.models.PeliculaRepository;
import com.example.repaso.services.PeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pelicula/")
public class PeliculaController {

    private final PeliculaService peliculaService;
    private final PeliculaRepository peliculaRepository;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> result = peliculaService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable long id) {
        return peliculaService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Pelicula> addPelicula(@RequestBody Pelicula pelicula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaRepository.add(pelicula));
    }

    @PutMapping("/{id}")
    public Pelicula edit(@PathVariable("id") long id, @RequestBody Pelicula pelicula) {
        return peliculaService.edit(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
         peliculaService.delete(id);
    }
}
