package com.example.monumento.services;

import com.example.monumento.error.MonumentNotFoundException;
import com.example.monumento.models.Monument;
import com.example.monumento.repositories.MonumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public List<Monument> getAll(){
        List<Monument> result = monumentRepository.getAll();
        if(result.isEmpty())
            throw new MonumentNotFoundException();

        return result;
    }

    public List<Monument> query(double maxLatitude, String sortDirection) {
        List<Monument> result = monumentRepository.query(maxLatitude, sortDirection);
        if (result.isEmpty())
            throw new MonumentNotFoundException();
        return result;
    }

    public Monument getMonument(Long id){
        return monumentRepository.findById(id)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public Monument add (Monument monument){
        return monumentRepository.add(monument);
    }

    public Monument edit(Long id, Monument monument){
        return monumentRepository.edit(id, monument)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public void delete(Long id){
        monumentRepository.delete(id);
    }
}
