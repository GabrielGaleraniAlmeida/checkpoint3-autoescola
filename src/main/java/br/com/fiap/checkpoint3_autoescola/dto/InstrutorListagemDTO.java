package br.com.fiap.checkpoint3_autoescola.dto;

import br.com.fiap.checkpoint3_autoescola.model.Especialidade;
import br.com.fiap.checkpoint3_autoescola.model.Instrutor;

public record InstrutorListagemDTO(Long id, String nome, String email, String cnh, Especialidade especialidade) {
    public InstrutorListagemDTO(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
    }
}