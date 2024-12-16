package com.example.monumento.error;

public class MonumentNotFoundException extends RuntimeException {

    public MonumentNotFoundException(Long id) {
        super("No hay monumentos con el ID: %d".formatted(id));
    }

    public MonumentNotFoundException(String msg) {
        super(msg);
    }

    public MonumentNotFoundException(){
        super("No se encontraron monumentos con esos requisitos de búsqueda.");
    }
}
