package br.ueg.progwebi.pacienteapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Paciente {
    @Id
    @Column(name = "PK")
    private long id;

    @Column(lenght = 200)
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private boolean pendencia;
    private String endereco;
}
