package com.proyecto.biblioteca.dto;

import com.proyecto.biblioteca.model.Usuario;
import com.proyecto.biblioteca.model.Rol;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String rol;

    // Constructor que recibe la entidad Usuario
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
        this.rol = usuario.getRoles().stream()
                .map(Rol::getNombreRol)
                .findFirst()
                .orElse("SIN_ROL");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
}
