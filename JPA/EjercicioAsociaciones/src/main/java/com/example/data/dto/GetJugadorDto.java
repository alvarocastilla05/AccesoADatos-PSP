package com.example.data.dto;

import com.example.data.model.Jugador;

public record GetJugadorDto(
        Long id,
        String nombre,
        String posicion
) {
    public static GetJugadorDto of(Jugador jugador){
        return new GetJugadorDto(
                jugador.getId(),
                jugador.getNombre(),
                jugador.getPosicion()
        );
    }
}
