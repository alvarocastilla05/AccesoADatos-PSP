package com.example.TiposHerencia.mappedSuperClass.repos;

import com.example.TiposHerencia.mappedSuperClass.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
