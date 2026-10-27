package com.grau.colegiodemo.controller;

import com.grau.colegiodemo.controller.ControllerHandler.RecursoNoEncontradoException;
import com.grau.colegiodemo.enums.TipoProfesor;
import com.grau.colegiodemo.modelo.Curso;
import com.grau.colegiodemo.modelo.Profesor;
import com.grau.colegiodemo.service.CursoService;
import com.grau.colegiodemo.service.ProfesorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfesorController.class)
class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CursoService cursoService;

    @Test
    void buscarPorId_CuandoExiste_DebeRetornar200() throws Exception {
        //('Programación I', 1),
        Integer id = 1;
        String nombreCurso = "Programación I";

        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombreCurso);

        when(cursoService.buscarPorId(curso.getId())).thenReturn(curso);

        mockMvc.perform(get("/api/cursos/{id}",id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nombre").value(nombreCurso));
    }

    @Test
    void buscarPorId_CuandoNoExiste_DebeRetornar404() throws Exception {
        Integer id = 999;
        // Arrange: simular que no existe el profesor
        when(cursoService.buscarPorId(id))
                .thenThrow(new RecursoNoEncontradoException("Curso con id " + id + " no existe"));

        // Act + Assert: comprobar que la respuesta sea 404
        mockMvc.perform(get("/api/cursos/{id}",id))
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    Exception excepcion = result.getResolvedException();
                    System.out.println("Excepción: " + excepcion);
                    System.out.println("Mensaje: " + excepcion.getMessage());

                    assertThat(result.getResolvedException())
                            .isInstanceOf(RecursoNoEncontradoException.class)
                            .hasMessage("Curso con id " + id + " no existe");
                });
    }
}