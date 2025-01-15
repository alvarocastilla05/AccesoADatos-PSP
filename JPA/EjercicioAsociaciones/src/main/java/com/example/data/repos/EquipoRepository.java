package com.example.data.repos;

import com.example.data.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
