package com.estudiantes.service;

import com.estudiantes.modelo.Estudiante;

import java.util.List;


public interface IEstudianteService {
    public List<Estudiante> listarEstudiante();

    public Estudiante buscarEstudiantePorId(Integer idEstudiante);

    public void guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);
}
