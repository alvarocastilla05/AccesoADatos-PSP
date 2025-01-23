package com.example.TiposHerencia.singleTable.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@DiscriminatorValue("Moto")
@Setter
@Getter
public class Moto extends Vehiculo{

    private int cilindros;
}
