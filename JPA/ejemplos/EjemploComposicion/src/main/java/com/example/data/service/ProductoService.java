package com.example.data.service;

import com.example.data.dto.EditProductoCmd;
import com.example.data.model.Categoria;
import com.example.data.model.Producto;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Producto> findAll() {
        /*
            Obetener todos los productos,
            si la lista esta vacia lanzo excepcion
         */
        List<Producto> result = productoRepository.findAll();
        if(result.isEmpty())
            throw new EntityNotFoundException("No hay productos con ese criterio de busqueda");

        return result;
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hay productos con id: "+ id));
    }

    public Producto save(EditProductoCmd nuevo) {

        return productoRepository.save(Producto.builder()
                        .nombre(nuevo.nombre())
                        .precio(nuevo.precio())
                        .descripcion(nuevo.descripcion())
                        //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                        .categoria(categoriaRepository.findById(nuevo.categoriaId()).orElse(null))
                .build());
    }

    public Producto edit(EditProductoCmd editProductoCmd, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(editProductoCmd.nombre());
                    old.setDescripcion(editProductoCmd.descripcion());
                    old.setPrecio(editProductoCmd.precio());
                    //old.setCategoria(categoriaRepository.getReferenceById(editProductoCmd.categoriaId()));
                    old.setCategoria(categoriaRepository.findById(editProductoCmd.categoriaId()).orElse(null));

                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay productos con id: "+ id));

    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
