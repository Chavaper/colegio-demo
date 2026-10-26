package com.grau.colegiodemo.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private Integer id;

    @NotBlank(message = "Debe ingresarse un nombre del curso")
    private String nombre;

    private Profesor profesor;
}
