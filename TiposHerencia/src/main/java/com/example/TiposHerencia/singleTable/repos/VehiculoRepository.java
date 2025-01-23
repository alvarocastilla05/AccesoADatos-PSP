package com.example.TiposHerencia.singleTable.repos;

import com.example.TiposHerencia.singleTable.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
