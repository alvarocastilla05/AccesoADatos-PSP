package com.example.Apartado2.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoPK  implements Serializable {
    private Long id;
    private CursoOnline cursoOnline;
}
