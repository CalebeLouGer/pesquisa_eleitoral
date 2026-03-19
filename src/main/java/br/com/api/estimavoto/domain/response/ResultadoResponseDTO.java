package br.com.api.estimavoto.domain.response;

import br.com.api.estimavoto.domain.municipio.grupo.Grupo;

import java.time.LocalDate;

public record ResultadoResponseDTO(
        Long id,
        LocalDate data,
        String municipio,
        String estado,
        Long candidato,
        Integer quantidadeDeVotos,
        Grupo grupo
) {
}
