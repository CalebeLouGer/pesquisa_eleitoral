package br.com.api.estimavoto.domain.pesquisa;

public record DadosDetalhamentoPesquisa(
        Long id,
        String data
) {
    public DadosDetalhamentoPesquisa(Pesquisa pesquisa) {
        this(
                pesquisa.getId(),
                pesquisa.getData().toString()
        );

    }
}