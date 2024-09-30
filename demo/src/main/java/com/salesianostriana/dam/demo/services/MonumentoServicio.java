package com.salesianostriana.dam.demo.services;

import com.salesianostriana.dam.demo.models.Monumento;
import com.salesianostriana.dam.demo.repositories.MonumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoServicio {
    @Autowired
    private MonumentoRepository monumentoRepository;


    public List<Monumento> findAll() {
        return monumentoRepository.findAll();
    }

    public Optional<Monumento> findById(Long id) {
        return monumentoRepository.findById(id);
    }

    public void saveOrUpdate(Monumento monumento) {
        monumentoRepository.save(monumento);
    }

    public void delete(Long id){
        monumentoRepository.deleteById(id);
    }
}
