package com.example.monumento.repositories;

import com.example.monumento.models.Monument;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentRepository {

    private HashMap<Long, Monument> monuments = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monument.builder().id(1L).
                cod_pais("ES").
                nombre("España")
                .nombre_ciudad("Úbeda")
                .latitud(12.0).longitud(15.0)
                .nombre_monumento("Museo de Alfarería Paco Tito")
                .descripcion("Sitio chulo chulo")
                .url_foto("https://multimedia.andalucia.org/fotos/image_290557.jpeg").build());
        add(Monument.builder().id(2L).
                cod_pais("ES").
                nombre("España")
                .nombre_ciudad("Úbeda")
                .latitud(12.0).longitud(15.0)
                .nombre_monumento("Museo de Alfarería Paco Tito")
                .descripcion("Sitio chulo chulo")
                .url_foto("https://multimedia.andalucia.org/fotos/image_290557.jpeg").build());
    }



    public Monument add(Monument monument) {
        monuments.put(monument.getId(), monument);
        return monument;
    }

    public Optional<Monument> findById(Long id) {
        return Optional.ofNullable(monuments.get(id));
    }

    public List<Monument> getAll() {
        return List.copyOf(monuments.values());
    }

    public Optional<Monument> edit(Long id, Monument newValue) {
        return Optional.ofNullable(monuments.computeIfPresent(id, (k, v) -> {
            v.setLatitud(newValue.getLatitud());
            v.setLongitud(newValue.getLongitud());
            v.setNombre(newValue.getNombre());
            v.setDescripcion(newValue.getDescripcion());
            v.setUrl_foto(newValue.getUrl_foto());
            v.setCod_pais(newValue.getCod_pais());
            v.setNombre_monumento(newValue.getNombre_monumento());
            v.setNombre_ciudad(newValue.getNombre_ciudad());

            return v;
        }));
    }

    public void delete(Long id) {
        monuments.remove(id);
    }

    public List<Monument> query(String nombre, String nombreCiudad) {
        List<Monument> data = new ArrayList<>(monuments.values());
        List<Monument> result = new ArrayList<>();

        if (nombre.equalsIgnoreCase("all")) {
            result = data;
        } else {
            result = data.stream().filter(m -> m.getNombre()
                    .equalsIgnoreCase(nombre)).collect(Collectors.toCollection(ArrayList::new));
        }

        if (nombreCiudad.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monument::getNombre_monumento));
        } else if (nombreCiudad.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monument::getNombre_monumento).reversed());

        }

        return Collections.unmodifiableList(result);


    }


}
