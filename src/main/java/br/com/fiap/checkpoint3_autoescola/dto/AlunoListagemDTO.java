package br.com.fiap.checkpoint3_autoescola.dto;

import br.com.fiap.checkpoint3_autoescola.model.Aluno;

public record AlunoListagemDTO(Long id, String nome, String email, String cpf) {
    public AlunoListagemDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}