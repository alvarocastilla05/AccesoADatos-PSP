package com.example.data.controller;

import com.example.data.dto.EditCategoriaCmd;
import com.example.data.dto.GetCategoriaDto;
import com.example.data.model.Categoria;
import com.example.data.service.CategoriaServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaServicio categoriaServicio;

    @GetMapping
    public List<GetCategoriaDto> getAll(){
        return categoriaServicio.findAll()
                .stream()
                .map(GetCategoriaDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id){
        return categoriaServicio.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody EditCategoriaCmd nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServicio.save(nuevo));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody EditCategoriaCmd editCategoriaCmd,@PathVariable("id") Long id){
        return categoriaServicio.edit(id, editCategoriaCmd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoriaServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}
