package br.com.api.estimavoto.domain.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findBySigla(String sigla);
}
