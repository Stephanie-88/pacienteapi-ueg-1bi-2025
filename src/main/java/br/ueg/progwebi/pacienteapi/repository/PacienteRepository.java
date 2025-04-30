package br.ueg.progwebi.pacienteapi.repository;

import br.ueg.progwebi.pacienteapi.model.Paciente;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente>findByNome(String nome);

    //JPQL
    @Query("select p from Paciente p where p.sexo = :sexo")
    Optional<List<Paciente>>findAllPacientesSexo(String sexo);

}


