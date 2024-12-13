package com.example.demo.error;

public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(Long id){
        super("No hay producto con id: %d".formatted(id));
    }

    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException(){
        super("No se ha encontrado producto");
    }
}
