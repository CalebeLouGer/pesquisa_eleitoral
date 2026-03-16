package br.com.api.estimavoto.repository;

import br.com.api.estimavoto.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
