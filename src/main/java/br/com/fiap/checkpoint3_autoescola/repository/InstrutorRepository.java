package br.com.fiap.checkpoint3_autoescola.repository;

import br.com.fiap.checkpoint3_autoescola.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Page<Instrutor> findAllByAtivoTrue(Pageable pageable);
}