package com.example.data;

import com.example.data.model.Equipo;
import com.example.data.model.Jugador;
import com.example.data.repos.EquipoRepository;
import com.example.data.repos.JugadorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

   private final JugadorRepository jugadorRepository;
   private final EquipoRepository equipoRepository;

    @PostConstruct
    public void run() {

        Equipo e = equipoRepository.getReferenceById(1L);

        Jugador j = Jugador.builder()
                .nombre("Messi")
                .posicion("extremo")
                .equipo(e)
                .build();

        jugadorRepository.save(j);

        Jugador j2 = Jugador.builder()
                .nombre("Cr7")
                .posicion("extremo")
                .equipo(e)
                .build();

        jugadorRepository.saveAll(List.of(j, j2));

    }

}