package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.dto.PrestamoDTO;
import com.proyecto.biblioteca.model.Prestamo;
import com.proyecto.biblioteca.model.Usuario;
import com.proyecto.biblioteca.model.Libro;
import com.proyecto.biblioteca.repository.PrestamoRepository;
import com.proyecto.biblioteca.repository.UsuarioRepository;
import com.proyecto.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LibroRepository libroRepository;

    public PrestamoDTO registrarPrestamo(Long usuarioId, Long libroId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if (!libro.isDisponible()) {
            throw new RuntimeException("El libro no está disponible");
        }

        libro.setDisponible(false);

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(LocalDate.now());

        Prestamo saved = prestamoRepository.save(prestamo);
        return new PrestamoDTO(saved);
    }

    public PrestamoDTO devolverPrestamo(Long prestamoId) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamo.getLibro().setDisponible(true);

        Prestamo saved = prestamoRepository.save(prestamo);
        return new PrestamoDTO(saved);
    }

    public List<PrestamoDTO> historialUsuario(Long usuarioId) {
        return prestamoRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(PrestamoDTO::new)
                .collect(Collectors.toList());
    }
}
