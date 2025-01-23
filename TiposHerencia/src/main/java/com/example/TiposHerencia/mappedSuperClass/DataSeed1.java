package com.example.TiposHerencia.mappedSuperClass;

import com.example.TiposHerencia.mappedSuperClass.model.Cliente;
import com.example.TiposHerencia.mappedSuperClass.model.Empleado;
import com.example.TiposHerencia.mappedSuperClass.repos.ClienteRepository;
import com.example.TiposHerencia.mappedSuperClass.repos.EmpleadoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed1 {

    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;

    @PostConstruct
    public void run(){

        Empleado empleado = new Empleado();
        empleado.setNombre("Alvaro");
        empleado.setEdad(19);
        empleado.setPuesto("Jefe");
        empleado.setSueldo(2000);

        empleadoRepository.save(empleado);

        Cliente cliente = new Cliente();
        cliente.setNombre("Lucas");
        cliente.setEdad(19);
        cliente.setNumeroCliente("123456");
        cliente.setDineroGastado(800);

        clienteRepository.save(cliente);

        System.out.println(cliente + " Dinero Gastado: " + cliente.getDineroGastado());
        System.out.println(empleado + " Sueldo: " + empleado.getSueldo());
    }
}
