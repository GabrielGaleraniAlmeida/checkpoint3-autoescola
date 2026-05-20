package br.com.fiap.checkpoint3_autoescola.controller;

import br.com.fiap.checkpoint3_autoescola.dto.InstrutorAtualizacaoDTO;
import br.com.fiap.checkpoint3_autoescola.dto.InstrutorCadastroDTO;
import br.com.fiap.checkpoint3_autoescola.dto.InstrutorListagemDTO;
import br.com.fiap.checkpoint3_autoescola.model.Instrutor;
import br.com.fiap.checkpoint3_autoescola.repository.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid InstrutorCadastroDTO dados) {
        repository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<InstrutorListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(InstrutorListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid InstrutorAtualizacaoDTO dados) {
        var instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var instrutor = repository.getReferenceById(id);
        instrutor.inativar();
    }
}