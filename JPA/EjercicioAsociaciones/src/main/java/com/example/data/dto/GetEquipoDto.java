package com.example.data.dto;

import com.example.data.model.Equipo;

public record GetEquipoDto(
        Long id,
        String nombre
) {
    public static GetEquipoDto of(Equipo equipo){
        return new GetEquipoDto(
                equipo.getId(),
                equipo.getNombre()
        );
    }
}
