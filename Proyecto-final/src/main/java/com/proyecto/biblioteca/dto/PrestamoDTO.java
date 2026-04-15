package com.proyecto.biblioteca.dto;

import com.proyecto.biblioteca.model.Prestamo;
import java.time.LocalDate;

public class PrestamoDTO {
    private Long id;
    private String usuarioNombre;
    private String libroTitulo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;

    // Constructor que recibe la entidad Prestamo
    public PrestamoDTO(Prestamo prestamo) {
        this.id = prestamo.getId();
        this.usuarioNombre = prestamo.getUsuario().getNombre();
        this.libroTitulo = prestamo.getLibro().getTitulo();
        this.fechaPrestamo = prestamo.getFechaPrestamo();
        this.fechaDevolucion = prestamo.getFechaDevolucion();
        this.devuelto = prestamo.isDevuelto();
    }

    // Getters
    public Long getId() { return id; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public String getLibroTitulo() { return libroTitulo; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public boolean isDevuelto() { return devuelto; }
}
