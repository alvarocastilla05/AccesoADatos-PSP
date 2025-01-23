package com.example.TiposHerencia.mappedSuperClass.repos;

import com.example.TiposHerencia.mappedSuperClass.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
