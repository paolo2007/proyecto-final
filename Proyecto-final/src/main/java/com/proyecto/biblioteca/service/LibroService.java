package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.dto.LibroDTO;
import com.proyecto.biblioteca.model.Libro;
import com.proyecto.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroDTO registrarLibro(Libro libro) {
        Libro saved = libroRepository.save(libro);
        return new LibroDTO(saved);
    }

    public List<LibroDTO> listarLibros() {
        return libroRepository.findAll()
                .stream()
                .map(LibroDTO::new)
                .collect(Collectors.toList());
    }
}
