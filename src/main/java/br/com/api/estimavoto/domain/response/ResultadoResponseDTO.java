package br.com.api.estimavoto.domain.response;

import java.time.LocalDate;

public record ResultadoResponseDTO(
        Long id,
        LocalDate data,
        String municipio,
        String estado,
        Long candidato,
        Integer quantidadeDeVotos
) {
}
