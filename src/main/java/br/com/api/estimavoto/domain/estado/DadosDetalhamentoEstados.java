package br.com.api.estimavoto.domain.estado;

import br.com.api.estimavoto.domain.municipio.DadosListagemMunicipio;

import java.util.List;

public record DadosDetalhamentoEstados(
        Long id,
        String nome,
        String sigla,
        List<DadosListagemMunicipio> municipios
) {
    public DadosDetalhamentoEstados(Estado e){
        this(e.getId(),
                e.getNome(),
                e.getSigla(),
                e.getMunicipios()
                        .stream()
                        .map(DadosListagemMunicipio::new)
                        .toList()
        );
    }
}
