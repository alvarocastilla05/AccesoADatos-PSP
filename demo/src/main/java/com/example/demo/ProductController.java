package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    /*@GetMapping
    public ResponseEntity<List<Product>> getAll(){
        /*
        * 1. Obtener del repositorio la lista de productos.
        * 2. Si la lista está vaciía, devolver 404.
        * 3. Si la lista tiene productos,
        * devolver 200 con la lista.
        */
       /* List<Product> result = productRepository.getAll();

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(result);
    }*/

    @GetMapping
    public ResponseEntity<List<Product>> getAll(
            @RequestParam(required = false,
                    value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = true, value = "sort", defaultValue = "no") String sortDirection
            ) {
        List<Product> result = productRepository.query(max, sortDirection);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.of(
                productRepository.get(id)
        );
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.add(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product product){
        return ResponseEntity.of(
                productRepository.edit(id, product)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productRepository.delete(id);
        return ResponseEntity.noContent().build();
    }


}
