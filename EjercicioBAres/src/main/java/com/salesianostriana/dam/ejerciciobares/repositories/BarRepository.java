package com.salesianostriana.dam.ejerciciobares.repositories;

import com.salesianostriana.dam.ejerciciobares.models.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
