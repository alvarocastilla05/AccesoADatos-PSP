package com.example.data.service;

import com.example.data.dto.EditCategoriaCmd;
import com.example.data.dto.GetCategoriaDto;
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

    public Categoria save(EditCategoriaCmd nuevo) {

        return categoriaRepository.save(Categoria.builder()
                .nombre(nuevo.nombre())
                .productos(nuevo.productos())
                .build()
        );
    }

    public Categoria edit(Long id, EditCategoriaCmd editCategoriaCmd) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editCategoriaCmd.nombre());
                    old.setProductos(editCategoriaCmd.productos());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado categoria"));
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
