package com.example.TiposHerencia.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cliente extends Persona{

    private String numeroCliente;

    private double dineroGastado;
}
