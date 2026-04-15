package com.proyecto.biblioteca.dto;

import com.proyecto.biblioteca.model.Libro;

public class LibroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor que recibe la entidad Libro
    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.disponible = libro.isDisponible();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
}
