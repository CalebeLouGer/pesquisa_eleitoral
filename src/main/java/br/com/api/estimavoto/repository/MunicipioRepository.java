package br.com.api.estimavoto.repository;

import br.com.api.estimavoto.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
}
