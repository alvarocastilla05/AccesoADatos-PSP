package com.example.repaso.models;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaRepository {

    private HashMap<Long, Pelicula> peliculas = new HashMap<>();

    public Pelicula add(Pelicula pelicula){
        peliculas.put(pelicula.getId(), pelicula);
        return pelicula;
    }

    public Optional<Pelicula> getById(long id){
        return Optional.ofNullable(peliculas.get(id));
    }

    public List<Pelicula> getAll(){
        return List.copyOf(peliculas.values());
    }

    public Optional<Pelicula> edit(Long id, Pelicula pelicula){
        return Optional.ofNullable(peliculas.computeIfPresent(id, (k, v) -> {
            v.setTitulo(pelicula.getTitulo());
            v.setDescripcion(pelicula.getDescripcion());
            v.setDirector(pelicula.getDirector());
            v.setActores(pelicula.getActores());
            return v;
        }));
    }

    public void delete(Long id){
        peliculas.remove(id);
    }
}
