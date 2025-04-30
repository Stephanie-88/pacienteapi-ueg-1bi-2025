package br.ueg.progwebi.pacienteapi.service;

import br.ueg.progwebi.pacienteapi.model.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> listAll();
    Paciente create(Paciente paciente);
    Paciente getbyId(long id);
    void delete(long id);
    Paciente update(Paciente paciente);
    List<Paciente> listPacienteSexoF(String sexo);
}
