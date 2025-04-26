package br.ueg.progwebi.pacienteapi.service.impl;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import br.ueg.progwebi.pacienteapi.service.PacienteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Override
    public List<Paciente> listAll() {
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

    @Override
    public Paciente create(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente getbyId(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Paciente update(Paciente paciente) {
        return null;
    }
}
