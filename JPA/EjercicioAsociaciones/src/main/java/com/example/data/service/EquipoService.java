package com.example.data.service;

import com.example.data.model.Equipo;
import com.example.data.repos.EquipoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public List<Equipo> findAll(){
        List<Equipo> result = equipoRepository.findAll();

        if(result.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado equipos con ese criterio");
        }
        return result;
    }

    public Equipo findById(Long id){
        return equipoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No hay equipos con el id:" +id));
    }

    public Equipo save(Equipo equipo){
        return equipoRepository.save(equipo);
    }
}
