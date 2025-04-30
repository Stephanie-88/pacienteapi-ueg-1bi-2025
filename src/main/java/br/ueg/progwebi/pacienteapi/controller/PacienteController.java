package br.ueg.progwebi.pacienteapi.controller;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import br.ueg.progwebi.pacienteapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listAll(){
        return pacienteService.listAll();
    }

    @PostMapping
    public Paciente create(@RequestBody Paciente paciente){
        return pacienteService.create(paciente);
    }

    @PostMapping(path = "/{id}")
    public Paciente update(@PathVariable long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return pacienteService.update(paciente);
    }

    @GetMapping(path = "/sexo/{sexo}")
    public List<Paciente> sexo(@PathVariable String sexo){
        return pacienteService.listPacienteSexoF(sexo);
    }

    @GetMapping(path = "/{id}")
    public Paciente getById(@PathVariable Long id) {
        Paciente paciente = this.pacienteService.getbyId(id);
        if(Objects.isNull(paciente)){
            throw new HttpClientErrorException(HttpStatusCode.valueOf(404), "Cliente não localizado");
        }
        return paciente;
    }

}

