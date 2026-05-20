package br.com.fiap.checkpoint3_autoescola.model;

import br.com.fiap.checkpoint3_autoescola.dto.AlunoAtualizacaoDTO;
import br.com.fiap.checkpoint3_autoescola.dto.AlunoCadastroDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    
    @Embedded
    private Endereco endereco;
    
    private Boolean ativo;

    public Aluno(AlunoCadastroDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(AlunoAtualizacaoDTO dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.endereco() != null) this.endereco.atualizarInformacoes(dados.endereco());
    }

    public void inativar() { this.ativo = false; }
}