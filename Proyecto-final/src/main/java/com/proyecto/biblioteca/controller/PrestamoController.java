package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.dto.PrestamoDTO;
import com.proyecto.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ADMIN')")
    public PrestamoDTO registrarPrestamo(@RequestParam Long usuarioId, @RequestParam Long libroId) {
        return prestamoService.registrarPrestamo(usuarioId, libroId);
    }

    @PutMapping("/devolver/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PrestamoDTO devolverPrestamo(@PathVariable Long id) {
        return prestamoService.devolverPrestamo(id);
    }

    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public List<PrestamoDTO> historialUsuario(@PathVariable Long id) {
        return prestamoService.historialUsuario(id);
    }
}
