package com.example.seguridad.controller;

import com.example.seguridad.model.EntidadTask;
import com.example.seguridad.service.EntidadTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entity/")
public class EntidadTaskController {

    private final EntidadTaskService entidadTaskService;

    @GetMapping
    public List<EntidadTask> findAll(){
        return entidadTaskService.findAll();
    }

    @GetMapping("{id}")
    public EntidadTask findById(@PathVariable Long id){
        return entidadTaskService.findById(id);
    }

    @PostMapping
    public ResponseEntity<EntidadTask> save(@RequestBody EntidadTask nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(entidadTaskService.save(nuevo));
    }
}
