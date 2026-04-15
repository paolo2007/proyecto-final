package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.dto.LibroDTO;
import com.proyecto.biblioteca.model.Libro;
import com.proyecto.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ADMIN')")
    public LibroDTO registrarLibro(@RequestBody Libro libro) {
        return libroService.registrarLibro(libro);
    }

    @GetMapping
    @PreAuthorize("hasRole('USUARIO')")
    public List<LibroDTO> listarLibros() {
        return libroService.listarLibros();
    }
}
