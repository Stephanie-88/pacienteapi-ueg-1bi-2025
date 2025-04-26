package br.ueg.progwebi.pacienteapi.controller;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import br.ueg.progwebi.pacienteapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listAll(){
        return pacienteService.listAll();
    }
}
