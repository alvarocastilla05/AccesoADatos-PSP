package com.salesianostriana.dam.ejemplo1.controller;

import com.salesianostriana.dam.ejemplo1.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingCotroller {

    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")  String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
