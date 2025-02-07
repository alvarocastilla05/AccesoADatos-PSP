package com.example.seguridad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EntidadTask {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
}
