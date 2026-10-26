package com.grau.colegiodemo.service;

import com.grau.colegiodemo.modelo.Curso;
import com.grau.colegiodemo.modelo.Profesor;

import java.util.List;

public interface ProfesorService {
    Integer crear(Profesor profesor);
    List<Profesor> listar();
    Profesor buscarPorId(Integer id);
    void actualizar(Profesor profesor);
    Integer eliminar(Integer id);
    List<Curso> listarCursos(Integer idProfesor);
}
