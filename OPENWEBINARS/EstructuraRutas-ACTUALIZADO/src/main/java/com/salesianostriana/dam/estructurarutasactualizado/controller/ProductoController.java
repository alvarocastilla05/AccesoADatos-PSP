package com.salesianostriana.dam.estructurarutasactualizado.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.salesianostriana.dam.estructurarutasactualizado.dto.CreateProductoDTO;
import com.salesianostriana.dam.estructurarutasactualizado.dto.ProductoDTO;
import com.salesianostriana.dam.estructurarutasactualizado.dto.converter.ProductoDTOConverter;
import com.salesianostriana.dam.estructurarutasactualizado.error.ProductoNotFoundException;
import com.salesianostriana.dam.estructurarutasactualizado.modelo.Categoria;
import com.salesianostriana.dam.estructurarutasactualizado.modelo.CategoriaRepositorio;
import com.salesianostriana.dam.estructurarutasactualizado.modelo.Producto;
import com.salesianostriana.dam.estructurarutasactualizado.modelo.ProductoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepositorio productoRepositorio;
    private final ProductoDTOConverter productoDTOConverter;
    private final CategoriaRepositorio categoriaRepositorio;

    /**
     * Obtenemos todos los productos
     *
     * @return
     */
    @GetMapping("/producto")
    public ResponseEntity<?> obtenerTodos() {
        List<Producto> result = productoRepositorio.findAll();

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            //return ResponseEntity.ok(result);
            List<ProductoDTO> dtoList =
                    result.stream()
                            .map(productoDTOConverter::convertToDTO)
                            .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos un producto en base a su ID
     *
     * @param id
     * @return Null si no encuentra el producto
     */
    @GetMapping("/producto/{id}")
    public Producto obtenerUno(@PathVariable Long id) {
        /*Producto result = productoRepositorio.findById(id).orElse(null);
        if(result == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(result);
        }*/
        return productoRepositorio.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));

    }

    /**
     * Insertamos un nuevo producto
     *
     * @param nuevo
     * @return producto insertado
     */
    @PostMapping("/producto")
    public ResponseEntity<Producto> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
        //Producto saved = productoRepositorio.save(nuevo);
        //return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nuevo.getNombre());
        nuevoProducto.setPrecio(nuevo.getPrecio());
        Categoria categoria = categoriaRepositorio.findById(nuevo.getCategoriaId()).orElse(null);
        nuevoProducto.setCategoria(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(nuevoProducto));


    }

    /**
     *
     * @param editar
     * @param id
     * @return
     */
    @PutMapping("/producto/{id}")
    public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {

        return productoRepositorio.findById(id).map(p -> {
                    p.setNombre(editar.getNombre());
                    p.setPrecio(editar.getPrecio());
                    return productoRepositorio.save(p);
                }).orElseThrow(() -> new ProductoNotFoundException(id));
        /*}).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });*/
    }




    /**
     * Borra un producto del catálogo en base a su id
     * @param id
     * @return
     */
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
        //productoRepositorio.deleteById(id);

        Producto producto = productoRepositorio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
        productoRepositorio.delete(producto);
        return ResponseEntity.noContent().build();

    }

}