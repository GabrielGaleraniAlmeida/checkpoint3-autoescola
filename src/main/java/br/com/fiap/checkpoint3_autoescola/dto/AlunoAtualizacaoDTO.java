package br.com.fiap.checkpoint3_autoescola.dto;

import jakarta.validation.constraints.NotNull;

public record AlunoAtualizacaoDTO(
    @NotNull Long id,
    String nome,
    String telefone,
    EnderecoDTO endereco
) {}