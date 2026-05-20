package br.com.fiap.checkpoint3_autoescola.dto;

import br.com.fiap.checkpoint3_autoescola.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstrutorCadastroDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String cnh,
    @NotNull Especialidade especialidade,
    @NotNull @Valid EnderecoDTO endereco
) {}