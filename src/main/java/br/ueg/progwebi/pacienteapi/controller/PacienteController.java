package br.ueg.progwebi.pacienteapi.controller;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    @GetMapping
    public List<Paciente> listAll(){
        Paciente paciente = new Paciente();
        paciente.setId(1l);
        paciente.setNome("João");
        paciente.setCpf("123.456.789");
        paciente.setSexo("M");
        paciente.setEndereco("Rua do Silva");
        paciente.setPendencia(true);
        paciente.setDataNascimento(LocalDate.of(1990, 1, 12));

        Paciente paciente2 = Paciente.builder()
                .id(2l)
                .nome("Maria")
                .cpf("899.233.145-58")
                .sexo("F")
                .endereco("Rua Ipiranga")
                .pendencia(false)
                .dataNascimento(LocalDate.of(2009,2,20))
                .build();
        List<Paciente> pacientes = Arrays.asList(paciente, paciente2);
        return pacientes;

    }
}
