package com.example.repaso.error;

public class PeliculaNotFound extends RuntimeException{

    public PeliculaNotFound(Long id){
        super("No existe peliculas con el id: %d".formatted(id));
    }

    public PeliculaNotFound(String msg){
        super(msg);
    }

    public PeliculaNotFound(){
        super("No existe peliculas");
    }
}
