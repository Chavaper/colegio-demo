package com.grau.colegiodemo.service;

import com.grau.colegiodemo.controller.ControllerHandler.RecursoNoEncontradoException;
import com.grau.colegiodemo.mapper.ProfesorMapper;
import com.grau.colegiodemo.modelo.Curso;
import com.grau.colegiodemo.modelo.Profesor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorMapper profesorMapper;

    @Override
    public Integer crear(Profesor profesor) {
        buscarPorId(profesor.getId());
        return profesorMapper.crear(profesor);
    }

    @Override
    public List<Profesor> listar() {
        return profesorMapper.listar();
    }

    @Override
    public Profesor buscarPorId(Integer id) {
        Profesor profesor = profesorMapper.buscarPorId(id); // o findById(id).orElseThrow(...)
        if (profesor == null) {
            throw new RecursoNoEncontradoException("Profesor con id " + id + " no encontrado");
        }
        return profesor;
    }

    @Override
    public void actualizar(Profesor profesor) {
        buscarPorId(profesor.getId());
        profesorMapper.actualizar(profesor);
    }

    @Override
    public Integer eliminar(Integer id) {
        buscarPorId(id);
        return profesorMapper.eliminar(id);
    }

    @Override
    public List<Curso> listarCursos(Integer idProfesor) {
        return profesorMapper.listarCursos(idProfesor);
    }
}
