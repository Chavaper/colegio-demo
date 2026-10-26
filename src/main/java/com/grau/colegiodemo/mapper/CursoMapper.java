package com.grau.colegiodemo.mapper;

import com.grau.colegiodemo.modelo.Curso;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CursoMapper {
    Integer crear(Curso curso);
    List<Curso> listar();
    Curso buscarPorId(Integer id);
    void actualizar(Curso curso);
    Integer eliminar(Integer id);
    List<Curso> listarPorProfesor( Integer idProfesor);
}
