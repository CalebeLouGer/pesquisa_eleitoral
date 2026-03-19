package br.com.api.estimavoto.domain.response;

import java.util.List;

public record EstadoResponseDTO(
        Long id,
        String nome,
        String sigla,
        List<MunicipioResponseDTO> municipios
) {
}
