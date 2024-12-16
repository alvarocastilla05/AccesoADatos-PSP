package com.example.monumento.repositories;

import com.example.monumento.error.MonumentNotFoundException;
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
        add(Monument.builder().id(1L)
                .cod_pais("ES")
                .nombre("España")
                .nombre_ciudad("Úbeda")
                .latitud(12.0).longitud(15.0)
                .nombre_monumento("Museo de Alfarería Paco Tito")
                .descripcion("Sitio chulo chulo")
                .url_foto("https://multimedia.andalucia.org/fotos/image_290557.jpeg").build());

        add(Monument.builder().id(2L)
                .cod_pais("ES")
                .nombre("España")
                .nombre_ciudad("Granada")
                .latitud(37.176).longitud(-3.588)
                .nombre_monumento("La Alhambra")
                .descripcion("Maravilla arquitectónica árabe")
                .url_foto("https://example.com/alhambra.jpeg").build());

        add(Monument.builder().id(3L)
                .cod_pais("IT")
                .nombre("Italia")
                .nombre_ciudad("Roma")
                .latitud(41.890).longitud(12.492)
                .nombre_monumento("Coliseo Romano")
                .descripcion("Un ícono de la antigua Roma")
                .url_foto("https://example.com/coliseo.jpeg").build());

        add(Monument.builder().id(4L)
                .cod_pais("FR")
                .nombre("Francia")
                .nombre_ciudad("París")
                .latitud(48.858).longitud(2.294)
                .nombre_monumento("Torre Eiffel")
                .descripcion("Símbolo de París y de Francia")
                .url_foto("https://example.com/torre-eiffel.jpeg").build());

        add(Monument.builder().id(5L)
                .cod_pais("US")
                .nombre("Estados Unidos")
                .nombre_ciudad("Nueva York")
                .latitud(40.689).longitud(-74.044)
                .nombre_monumento("Estatua de la Libertad")
                .descripcion("Regalo de Francia a los EE.UU.")
                .url_foto("https://example.com/estatua-libertad.jpeg").build());

        add(Monument.builder().id(6L)
                .cod_pais("JP")
                .nombre("Japón")
                .nombre_ciudad("Kioto")
                .latitud(35.011).longitud(135.768)
                .nombre_monumento("Kinkaku-ji")
                .descripcion("El Pabellón Dorado, un templo zen")
                .url_foto("https://example.com/kinkakuji.jpeg").build());
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

    public List<Monument> query(double maxLatitude, String sortDirection) {
        List<Monument> data = new ArrayList<>(monuments.values());
        List<Monument> result;

        if (maxLatitude < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getLatitud() <= maxLatitude)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monument::getNombre_monumento));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monument::getNombre_monumento).reversed());

        return Collections.unmodifiableList(result);
    }



}
