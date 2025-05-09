package br.ueg.progwebi.pacienteapi.service.impl;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import br.ueg.progwebi.pacienteapi.repository.PacienteRepository;
import br.ueg.progwebi.pacienteapi.service.PacienteService;
import br.ueg.progwebi.pacienteapi.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;


    @Override
    public List<Paciente> listAll() {

        return repository.findAll();
    }

    @Override
    public Paciente create(Paciente paciente) {
        if(Strings.isEmpty(paciente.getNome())){
            throw new RuntimeException("O nome não pode ser vazio!");
        }

        Optional<Paciente> checkExist = repository.findById(paciente.getId());
        if(checkExist.isPresent()){
            throw new RuntimeException("Esse paciente já existe!");
        }

        Optional<Paciente> checkExist2 = repository.findByNome(paciente.getNome());
        if(checkExist2.isPresent()){
            throw new RuntimeException("Já existe um paciente com esse nome.");
        }

        return repository.save(paciente);
    }

    @Override
    public Paciente getbyId(long id) {
        Optional<Paciente> paciente = this.repository.findById(id);
        if(paciente.isPresent()){
            return paciente.get();
        }
        return null;
    }

    @Override
    public Paciente delete(long id) {
        Optional<Paciente> paciente = repository.findById(id);
        if(Boolean.FALSE.equals(paciente.isPresent())){
            throw new BusinessException("Id do paciente: " + id + "não encontrado.",404);
        }


        try {
            repository.delete(paciente.get());
        }catch (DataIntegrityViolationException e){
            throw new BusinessException("Id do paciente: " + id + "não pode ser removido por questões de integriade")
        }

        return paciente.get();
    }

    @Override
    public Paciente update(Paciente paciente) {
        if(Strings.isEmpty(paciente.getNome()) || Objects.isNull(paciente.getId())){
            throw new RuntimeException("OInformação incompleta (nome ou ID)");
        }

        return repository.save(paciente);
    }

    @Override
    public List<Paciente> listPacienteSexoF(String sexo) {
        Optional<List<Paciente>> allPacientesSexo = repository.findAllPacientesSexo(sexo);
        return allPacientesSexo.orElseGet(List::of);
    }
}
