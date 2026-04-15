package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.model.Usuario;
import com.proyecto.biblioteca.model.Rol;
import com.proyecto.biblioteca.repository.RolRepository;
import com.proyecto.biblioteca.service.UsuarioService;
import com.proyecto.biblioteca.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService;
    private final RolRepository rolRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService, RolRepository rolRepository, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.rolRepository = rolRepository;
        this.jwtUtil = jwtUtil;
    }

    // Registro de usuario con rol USUARIO por defecto
    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        Rol rolUsuario = rolRepository.findByNombreRol("USUARIO")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRoles(Set.of(rolUsuario));
        return usuarioService.registrarUsuario(usuario);
    }

    // Login y generación de token JWT con roles
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> datos) {
        Usuario usuario = usuarioService.buscarPorEmail(datos.get("email"))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(datos.get("password"))) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Convertir roles del usuario a lista con prefijo ROLE_
        List<String> roles = usuario.getRoles().stream()
                .map(r -> "ROLE_" + r.getNombreRol())
                .collect(Collectors.toList());

        // Generar token con lista de roles
        String token = jwtUtil.generarToken(usuario.getEmail(), roles);

        return Map.of("token", token);
    }
}
