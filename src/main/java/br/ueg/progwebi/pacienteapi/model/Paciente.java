package br.ueg.progwebi.pacienteapi.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paciente {
    private long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private boolean pendencia;
    private String endereco;
}
