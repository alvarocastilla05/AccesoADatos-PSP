package com.salesianostriana.dam.demo.repositories;

import com.salesianostriana.dam.demo.models.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
