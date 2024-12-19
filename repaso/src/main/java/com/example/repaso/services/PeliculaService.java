package com.example.repaso.services;

import com.example.repaso.error.PeliculaNotFound;
import com.example.repaso.models.Pelicula;
import com.example.repaso.models.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public List<Pelicula> getAll() {
        List<Pelicula> result = peliculaRepository.getAll();

        if(result.isEmpty())
            throw new PeliculaNotFound();

        return result;
    }

    public Pelicula getById(long id) {
        return peliculaRepository.getById(id).orElseThrow(() -> new PeliculaNotFound(id));
    }

    public Pelicula create(Pelicula pelicula) {
        return peliculaRepository.add(pelicula);
    }

    public Pelicula edit(long id, Pelicula pelicula) {
        return peliculaRepository.edit(id, pelicula).orElseThrow(() -> new PeliculaNotFound(id));
    }

    public void delete(long id) {
         peliculaRepository.delete(id);
    }
}
