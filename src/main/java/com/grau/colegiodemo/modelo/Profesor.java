package com.grau.colegiodemo.modelo;

import com.grau.colegiodemo.enums.TipoProfesor;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    private Integer id;

    @NotBlank(message = "Debe ingresarse el nombre del profesor")
    private String nombre;
    @NotBlank(message = "Debe ingresarse los apellidos del profesor")
    private String apellido;
    private List<Curso> cursos;
    @NotBlank(message = "Debe ingresarse el tipo de profesor")
    private TipoProfesor tipo;
}
