package com.example.Apartado2;

import com.example.Apartado2.model.CursoOnline;
import com.example.Apartado2.model.Profesor;
import com.example.Apartado2.model.Video;
import com.example.Apartado2.repositories.CursoOnlineRepository;
import com.example.Apartado2.repositories.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProfesorRepository profesorRepository;
    private final CursoOnlineRepository cursoOnlineRepository;

    @PostConstruct
    public void run(){
        Profesor p = Profesor.builder()
                .nombre("Manolo")
                .email("a@a")
                .puntuacion(9)
                .build();

        profesorRepository.save(p);

        CursoOnline c = CursoOnline.builder()
                .nombre("PepeCurso")
                .puntuacion(7)
                .profesor(p)
                .build();

        //cursoOnlineRepository.save(c);

        Video v = Video.builder()
                .titulo("Cabestro")
                .url("pira pira pira")
                //.cursoOnline(c)
                .build();

        Video v1 = Video.builder()
                .titulo("Iruaaaa")
                .url("piru piru piru")
                //.cursoOnline(c)
                .build();

        c.addVideo(v);
        c.addVideo(v1);

        cursoOnlineRepository.save(c);

        Video v2 = Video.builder()
                .titulo("Vídeo creado por luismi")
                .url("piru piru piru")
                //.cursoOnline(c)
                .build();


        c.addVideo(v2);

        cursoOnlineRepository.save(c);

        //p.addCursoOnline(c);

        System.out.println(p);
        System.out.println(c);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);

        System.out.println(c.getVideos());


        /*c.deleteVideos(v1);

        cursoOnlineRepository.save(c);*/

        cursoOnlineRepository.delete(c);
    }
}
