package br.com.api.estimavoto.repository;

import br.com.api.estimavoto.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisaService extends JpaRepository<Pesquisa, Long> {
}
