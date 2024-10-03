package com.salesianostriana.dam.ejerciciobares.services;

import com.salesianostriana.dam.ejerciciobares.models.Bar;
import com.salesianostriana.dam.ejerciciobares.models.Tag;
import com.salesianostriana.dam.ejerciciobares.repositories.BarRepository;
import com.salesianostriana.dam.ejerciciobares.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    public Optional<Bar> findById(Long id) {

        return barRepository.findById(id);
    }

    public Bar modificar (Long id, Bar bar) {
        Bar barEncontrado = barRepository.findById(id).orElse(null);
        if(barEncontrado != null) {
            barEncontrado.setDescripcion(bar.getDescripcion());
            barEncontrado.setNombre(bar.getNombre());
            barEncontrado.setLatitud(bar.getLatitud());
            barEncontrado.setLongitud(bar.getLongitud());
            barEncontrado.setUrlImagen(bar.getUrlImagen());
            barEncontrado.setDireccion(bar.getDireccion());
        }
        return barRepository.save(barEncontrado);
    }

    public Bar guardarBar (Bar bar) {
        return barRepository.save(bar);
    }

    public void eliminarBar (Long id) {

        barRepository.deleteById(id);
    }

    public Bar aniadirTag (Long id, Tag tag) {
        Bar bar = barRepository.findById(id).orElse(null);
        if(bar != null) {
            bar.getTags().add(tag);
            tag.getBares().add(bar);

            tagRepository.save(tag);
        }
        return barRepository.save(bar);
    }

    public Bar borrarTagDeBar (Long id, Tag tag) {
        Bar bar = barRepository.findById(id).orElse(null);
        if (bar != null) {
            bar.getTags().remove(tag);
            tag.getBares().remove(bar);
            tagRepository.save(tag);

        }
        return barRepository.save(bar);

    }
}
