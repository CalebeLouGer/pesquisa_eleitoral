package br.com.api.estimavoto.domain.pesquisa;

import java.time.LocalDate;

public record DadosListagemPesquisa(
        Long id,
        LocalDate data
) {
    public DadosListagemPesquisa(Pesquisa pesquisa){
        this(pesquisa.getId(),
                pesquisa.getData());
    }
}
