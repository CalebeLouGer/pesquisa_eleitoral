package br.com.api.estimavoto.domain.pesquisa.resultado;

import java.util.Map;

public record ResultadoPesquisa(
        Long id,
        String dataPesquisa,
        String municipio,
        String estado,
        Map<String, Long> quantidadeVotos
) {
}
