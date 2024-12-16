package com.example.monumento.controller;

import com.example.monumento.models.Monument;
import com.example.monumento.repositories.MonumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor

public class MonumentController {

    private final MonumentRepository monumentRepository;

    @GetMapping
    public ResponseEntity<List<Monument>> getAllMonuments(
            @RequestParam(required = false, value = "countryName", defaultValue = "all") String monumentName,
            @RequestParam(required = false, value = "sort", defaultValue = "desc") String sortDirection) {
        List<Monument> result = monumentRepository.query(monumentName, sortDirection);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monument> getMonumentById(@PathVariable Long id) {
        return ResponseEntity.of(
                monumentRepository.findById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Monument> createMonument(@RequestBody Monument monument) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(monumentRepository.add(monument));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monument> updateMonument(@PathVariable("id") Long id, @RequestBody Monument monument) {
        return ResponseEntity.of(
                monumentRepository.edit(id, monument)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonument(@PathVariable("id") Long id) {
        monumentRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
