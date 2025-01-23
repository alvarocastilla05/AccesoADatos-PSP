package com.example.TiposHerencia.joined.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class UsuarioPremium extends Usuario{

    private String planPremium;

    private LocalDate fechaFinPremium;
}
