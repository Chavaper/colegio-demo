package com.grau.colegiodemo.mapper;

import com.grau.colegiodemo.modelo.Curso;
import com.grau.colegiodemo.modelo.Profesor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfesorMapper {
    Integer crear(Profesor profesor);
    List<Profesor> listar();
    Profesor buscarPorId(Integer id);
    void actualizar(Profesor profesor);
    Integer eliminar(Integer id);
    List<Curso> listarCursos(Integer idProfesor);
}
