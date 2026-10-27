package com.grau.colegiodemo.service;

import com.grau.colegiodemo.controller.ControllerHandler.RecursoNoEncontradoException;
import com.grau.colegiodemo.mapper.CursoMapper;
import com.grau.colegiodemo.modelo.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoMapper cursoMapper;

    @Override
    public Integer crear(Curso curso) {
        return cursoMapper.crear(curso);
    }

    @Override
    public List<Curso> listar() {
        return cursoMapper.listar();
    }

    @Override
    public Curso buscarPorId(Integer id) {
        Curso curso = cursoMapper.buscarPorId(id);
        if(curso == null){
            throw new RecursoNoEncontradoException("Curso con id " + id + " no encontrado");
        }
        return curso;
    }

    @Override
    public void actualizar(Curso curso) {
        buscarPorId(curso.getId());
        cursoMapper.actualizar(curso);
    }

    @Override
    public Integer eliminar(Integer id) {
        buscarPorId(id);
        return cursoMapper.eliminar(id);
    }

    @Override
    public List<Curso> listarPorProfesor(Integer idProfesor) {
        return cursoMapper.listarPorProfesor(idProfesor);
    }
}
