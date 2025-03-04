package com.example.repaso.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ProblemDetail handlePeliculaNotFound(Exception ex) {
        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        ex.getMessage());
        result.setTitle("Pelicula no encontrada");
        result.setType(URI.create("www.salesianostriana.edu"));
        result.setProperty("author", "Álvaro");

        return result;
    }
}
