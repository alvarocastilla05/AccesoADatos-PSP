package com.salesianostriana.dam.ejerciciobares.services;

import com.salesianostriana.dam.ejerciciobares.models.Bar;
import com.salesianostriana.dam.ejerciciobares.models.Tag;
import com.salesianostriana.dam.ejerciciobares.repositories.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    public Optional<Bar> findById(Long id) {

        return barRepository.findById(id);
    }

    public Bar modificar (Long id, Bar bar) {
        Bar barEncontrado = barRepository.findById(id).orElse(null);
        if(barEncontrado != null) {
            return barRepository.save(barEncontrado);
        }
        return barEncontrado;
    }

    public Bar guardarBar (Bar bar) {
        return barRepository.save(bar);
    }

    public void eliminarBar (Long id) {
        barRepository.deleteById(id);
    }
}
