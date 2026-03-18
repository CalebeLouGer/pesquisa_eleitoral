package br.com.api.estimavoto.domain.pesquisa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    @Query("""
    SELECT p FROM Pesquisa p
    WHERE p.id = :id
    """)
    Optional<Pesquisa> buscarDetalhado(Long id);

}
