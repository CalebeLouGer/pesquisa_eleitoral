package br.com.api.estimavoto.repository;

import br.com.api.estimavoto.model.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrevistaRepository extends JpaRepository<Entrevista, Long> {
}
