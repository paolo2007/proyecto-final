package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.model.Usuario;
import com.proyecto.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }


    public List<Usuario> obtenerTodos() {
        return repo.findAll();
    }
}
