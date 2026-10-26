
package com.grau.colegiodemo.controller;

import com.grau.colegiodemo.modelo.Curso;
import com.grau.colegiodemo.modelo.Profesor;
import com.grau.colegiodemo.service.ProfesorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<List<Profesor>> listar() {
        return ResponseEntity.ok(profesorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(profesorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Profesor> crear(@Valid @RequestBody Profesor profesor) {
        profesorService.crear(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(profesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Profesor profesor) {
        profesor.setId(id);
        profesorService.actualizar(profesor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<Curso>> listarCursos(@PathVariable Integer id) {
        return ResponseEntity.ok(profesorService.listarCursos(id));
    }
}