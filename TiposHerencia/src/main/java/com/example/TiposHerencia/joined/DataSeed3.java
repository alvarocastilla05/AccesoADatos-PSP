package com.example.TiposHerencia.joined;

import com.example.TiposHerencia.joined.model.Usuario;
import com.example.TiposHerencia.joined.model.UsuarioPremium;
import com.example.TiposHerencia.joined.repos.UsuarioPremiumRepository;
import com.example.TiposHerencia.joined.repos.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeed3 {

    private final UsuarioPremiumRepository usuarioPremiumRepository;
    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void run(){

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("juanperez");
        usuario.setCorreo("juan.perez@example.com");
        usuarioRepository.save(usuario);

        // Crear un usuario premium
        UsuarioPremium usuarioPremium = new UsuarioPremium();
        usuarioPremium.setNombreUsuario("anagonzalez");
        usuarioPremium.setCorreo("ana.gonzalez@example.com");
        usuarioPremium.setPlanPremium("Gold");
        usuarioPremium.setFechaFinPremium(LocalDate.now().plusMonths(6));
        usuarioPremiumRepository.save(usuarioPremium);

        System.out.println(usuario);
        System.out.println(usuarioPremium);
    }
}
