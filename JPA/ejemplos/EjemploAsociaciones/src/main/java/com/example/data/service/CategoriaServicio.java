package com.example.data.service;

import com.example.data.model.Categoria;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServicio {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public List<Categoria> findAll() {

        List<Categoria> result = categoriaRepository.findAll();

        if(result.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado ninguna categoria");
        }
        return result;
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se han encontrado categoria con ID: " + id));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado categoria"));
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
