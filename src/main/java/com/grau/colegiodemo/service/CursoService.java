package com.grau.colegiodemo.service;


import com.grau.colegiodemo.modelo.Curso;

import java.util.List;

public interface CursoService {
    Integer crear(Curso curso);
    List<Curso> listar();
    Curso buscarPorId(Integer id);
    void actualizar(Curso curso);
    Integer eliminar(Integer id);
    List<Curso> listarPorProfesor(Integer idProfesor);
}
