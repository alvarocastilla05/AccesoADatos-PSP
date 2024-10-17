package com.salesianostriana.dam.estructurarutasactualizado.dto.converter;

import com.salesianostriana.dam.estructurarutasactualizado.dto.ProductoDTO;
import com.salesianostriana.dam.estructurarutasactualizado.modelo.Producto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {

    private final ModelMapper modelMapper;

    public ProductoDTO convertToDTO(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);
    }
}
