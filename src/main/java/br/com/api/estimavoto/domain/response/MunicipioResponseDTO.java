package br.com.api.estimavoto.domain.response;

import java.util.List;

public record MunicipioResponseDTO(
        String nome,
        List<ResultadoResponseDTO> resultados
) {
}
