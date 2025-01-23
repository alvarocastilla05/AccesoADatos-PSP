package com.example.TiposHerencia.mappedSuperClass.repos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Coche extends JpaRepository<Coche, Long> {
}
