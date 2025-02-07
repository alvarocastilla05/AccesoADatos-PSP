package com.example.seguridad.service;

import com.example.seguridad.model.EntidadTask;
import com.example.seguridad.repos.EntidadTaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntidadTaskService {

    private final EntidadTaskRepository entidadTaskRepository;

    public List<EntidadTask> findAll(){

        return entidadTaskRepository.findAll();
    }

    public EntidadTask findById(Long id){

        Optional<EntidadTask> result = entidadTaskRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }else {
            throw new EntityNotFoundException("No hay entity con id: "+id);
        }
    }

    public EntidadTask save(EntidadTask nuevo){
        return entidadTaskRepository.save(nuevo);
    }
}
