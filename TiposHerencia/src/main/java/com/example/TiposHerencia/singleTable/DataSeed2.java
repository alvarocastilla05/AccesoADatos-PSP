package com.example.TiposHerencia.singleTable;

import com.example.TiposHerencia.singleTable.model.Coche;
import com.example.TiposHerencia.singleTable.model.Moto;
import com.example.TiposHerencia.singleTable.repos.VehiculoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed2 {

    private final VehiculoRepository vehiculoRepository;

    @PostConstruct
    public void run(){
        Coche coche = new Coche();
        coche.setMarca("Toyota");
        coche.setModelo("Corolla");
        coche.setPuertas(4);

        vehiculoRepository.save(coche);

        Moto moto = new Moto();
        moto.setMarca("Yamaha");
        moto.setModelo("R1");
        moto.setCilindros(2);

        vehiculoRepository.save(moto);

        System.out.println("Marca: " + coche.getMarca() + ", Modelo: " + coche.getModelo() + ", Nº Puertas: " + coche.getPuertas());
        System.out.println("Marca: " + moto.getMarca() + ", Modelo: " + moto.getModelo() + ", Nº Cilindros: " + moto.getCilindros());
    }
}
