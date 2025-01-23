package com.example.TiposHerencia.joined.repos;

import com.example.TiposHerencia.joined.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
