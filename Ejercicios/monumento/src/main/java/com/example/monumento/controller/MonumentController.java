package com.example.monumento.controller;

import com.example.monumento.models.Monument;
import com.example.monumento.repositories.MonumentRepository;
import com.example.monumento.services.MonumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "El controlador de monumentos, para poder realizar todas las operaciones de gestión")
public class MonumentController {

    private final MonumentRepository monumentRepository;
    private final MonumentService monumentService;


    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los monumentos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monument.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                  {
                                                      "id": 1,
                                                      "cod_pais": "ES",
                                                      "nombre": "España",
                                                      "nombre_ciudad": "Úbeda",
                                                      "latitud": 12.0,
                                                      "longitud": 15.0,
                                                      "nombre_monumento": "Museo de Alfarería Paco Tito",
                                                      "descripcion": "Sitio chulo chulo",
                                                      "url_foto": "https://multimedia.andalucia.org/fotos/image_290557.jpeg"
                                                  },
                                                  {
                                                           "id": 2,
                                                           "cod_pais": "ES",
                                                           "nombre": "España",
                                                           "nombre_ciudad": "Granada",
                                                           "latitud": 37.176,
                                                           "longitud": -3.588,
                                                           "nombre_monumento": "La Alhambra",
                                                           "descripcion": "Maravilla arquitectónica árabe",
                                                           "url_foto": "https://example.com/alhambra.jpeg"
                                                  }
                                              ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado ningún monumento.",
                    content = @Content()),
    })
    @GetMapping
    public ResponseEntity<List<Monument>> getAllMonuments(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {

        if (latitude != null && latitude != 0.0) {
            List<Monument> result = monumentService.query(latitude, sort);
            return ResponseEntity.ok(result);
        }else {
            List<Monument> result = monumentService.getAll();
            return ResponseEntity.ok(result);
        }




    }

    @Operation(summary = "Obtiene los monumentos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado un monumento con ese id",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monument.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                  {
                                                      "id": 1,
                                                      "cod_pais": "ES",
                                                      "nombre": "España",
                                                      "nombre_ciudad": "Úbeda",
                                                      "latitud": 12.0,
                                                      "longitud": 15.0,
                                                      "nombre_monumento": "Museo de Alfarería Paco Tito",
                                                      "descripcion": "Sitio chulo chulo",
                                                      "url_foto": "https://multimedia.andalucia.org/fotos/image_290557.jpeg"
                                                  }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado ningún monumento.",
                    content = @Content()),
    })
    @GetMapping("/{id}")
    public Monument getMonumentById(@PathVariable Long id) {
        return monumentService.getMonument(id);
    }

    @Operation(summary = "Crea un nuevo Monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Monumento creado",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monument.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                  {
                                                      "id": 1,
                                                      "cod_pais": "ES",
                                                      "nombre": "España",
                                                      "nombre_ciudad": "Úbeda",
                                                      "latitud": 12.0,
                                                      "longitud": 15.0,
                                                      "nombre_monumento": "Museo de Alfarería Paco Tito",
                                                      "descripcion": "Sitio chulisimo",
                                                      "url_foto": "https://multimedia.andalucia.org/fotos/image_290557.jpeg"
                                                  }
                                            """
                            )}
                    )})
    })
    @PostMapping
    public ResponseEntity<Monument> createMonument(@RequestBody Monument monument) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(monumentService.add(monument));
    }

    @Operation(summary = "Edita un monumento en concreto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Monumento editado",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monument.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                  {
                                                      "id": 1,
                                                      "cod_pais": "ES",
                                                      "nombre": "España",
                                                      "nombre_ciudad": "Úbeda",
                                                      "latitud": 12.0,
                                                      "longitud": 15.0,
                                                      "nombre_monumento": "Museo de Alfarería Paco Tito",
                                                      "descripcion": "Sitio chulisimo",
                                                      "url_foto": "https://multimedia.andalucia.org/fotos/image_290557.jpeg"
                                                  }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado ningún monumento.",
                    content = @Content()),
    })
    @PutMapping("/{id}")
    public Monument updateMonument(@PathVariable("id") Long id, @RequestBody Monument monument) {
        return monumentService.edit(id, monument);
    }

    @Operation(summary = "Elimina un monumento en concreto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Monumeno eliminado",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monument.class))
                    )})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonument(@PathVariable("id") Long id) {
        monumentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
