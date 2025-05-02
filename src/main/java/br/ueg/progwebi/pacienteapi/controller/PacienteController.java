package br.ueg.progwebi.pacienteapi.controller;

import br.ueg.progwebi.pacienteapi.controller.exceptions.ResourceNotFoundException;
import br.ueg.progwebi.pacienteapi.model.Paciente;
import br.ueg.progwebi.pacienteapi.service.PacienteService;
import br.ueg.progwebi.pacienteapi.service.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
            throw new ResourceNotFoundException("Cliente não localizado");
        }
        return paciente;
    }

    @DeleteMapping(path = "/{id}")
    public Paciente delete(@PathVariable Long id){
        Paciente paciente;
        try {
            paciente = this.pacienteService.delete(id);
        }catch (BusinessException e){
            throw new ResponseStatusException(e.getCodeError(), e.getMessage(), e);
        }

        return paciente;
    }

}

