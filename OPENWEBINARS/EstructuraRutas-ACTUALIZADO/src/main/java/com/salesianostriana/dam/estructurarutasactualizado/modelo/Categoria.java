package com.salesianostriana.dam.estructurarutasactualizado.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categoria {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
}
