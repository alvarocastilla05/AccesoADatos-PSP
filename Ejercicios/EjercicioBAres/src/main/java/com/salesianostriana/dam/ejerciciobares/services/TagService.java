package com.salesianostriana.dam.ejerciciobares.services;

import com.salesianostriana.dam.ejerciciobares.models.Tag;
import com.salesianostriana.dam.ejerciciobares.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;


    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long id) {

        return tagRepository.findById(id);
    }

    public Tag modificar (Long id, Tag tag) {
        Tag tagEncontrado = tagRepository.findById(id).orElse(null);
        if(tagEncontrado != null) {
            return tagRepository.save(tagEncontrado);
        }
        return tagEncontrado;
    }

    public Tag guardarTag (Tag tag) {
        return tagRepository.save(tag);
    }

    public void eliminarTag (Long id) {
        tagRepository.deleteById(id);
    }


}
