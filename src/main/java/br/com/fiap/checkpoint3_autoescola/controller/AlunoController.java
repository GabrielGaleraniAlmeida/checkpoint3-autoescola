package br.com.fiap.checkpoint3_autoescola.controller;

import br.com.fiap.checkpoint3_autoescola.dto.AlunoAtualizacaoDTO;
import br.com.fiap.checkpoint3_autoescola.dto.AlunoCadastroDTO;
import br.com.fiap.checkpoint3_autoescola.dto.AlunoListagemDTO;
import br.com.fiap.checkpoint3_autoescola.model.Aluno;
import br.com.fiap.checkpoint3_autoescola.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid AlunoCadastroDTO dados) {
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<AlunoListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(AlunoListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AlunoAtualizacaoDTO dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.inativar();
    }
}