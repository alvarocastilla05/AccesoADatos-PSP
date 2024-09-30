package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.models.Monumento;
import com.salesianostriana.dam.demo.services.MonumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MonumentoController {
    @Autowired
    private MonumentoServicio servicio;

    @GetMapping("/nuevo")
    public String aniadirMonumento(Model model){
        Monumento monumento = new Monumento();
        model.addAttribute("monumento", monumento);

        return "redirect:/nuevo";
    }
}
