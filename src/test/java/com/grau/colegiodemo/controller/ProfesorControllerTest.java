package com.grau.colegiodemo.controller;

import com.grau.colegiodemo.controller.ControllerHandler.RecursoNoEncontradoException;
import com.grau.colegiodemo.enums.TipoProfesor;
import com.grau.colegiodemo.modelo.Profesor;
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
class ProfesorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProfesorService profesorService;

    @Test
    void buscarPorId_CuandoExiste_DebeRetornar200() throws Exception {
        //('Carlos', 'Ramírez', 'TP'),
        Profesor profesor = new Profesor();
        profesor.setId(1);
        profesor.setNombre("Carlos");
        profesor.setApellido("Ramírez");
        profesor.setTipo(TipoProfesor.TP);

        when(profesorService.buscarPorId(profesor.getId())).thenReturn(profesor);

        mockMvc.perform(get("/api/profesores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Carlos"))
                .andExpect(jsonPath("$.apellido").value("Ramírez"))
                .andExpect(jsonPath("$.tipo").value("TP"));
    }

    @Test
    void buscarPorId_CuandoNoExiste_DebeRetornar404() throws Exception {
        Integer id = 999;
        // Arrange: simular que no existe el profesor
        when(profesorService.buscarPorId(id))
                .thenThrow(new RecursoNoEncontradoException("Profesor con id " + id + " no existe"));

        // Act + Assert: comprobar que la respuesta sea 404
        mockMvc.perform(get("/api/profesores/{id}",id))
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    Exception excepcion = result.getResolvedException();
                    System.out.println("Excepción: " + excepcion);
                    System.out.println("Mensaje: " + excepcion.getMessage());

                    assertThat(result.getResolvedException())
                            .isInstanceOf(RecursoNoEncontradoException.class)
                            .hasMessage("Profesor con id " + id + " no existe");
                });
    }
}