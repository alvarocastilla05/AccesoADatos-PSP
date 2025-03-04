package com.example.data.service;

import com.example.data.model.Producto;
import com.example.data.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

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

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto edit(Producto producto, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.getNombre());
                    old.setDescripcion(producto.getDescripcion());
                    old.setPrecio(producto.getPrecio());
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay productos con id: "+ id));

    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
