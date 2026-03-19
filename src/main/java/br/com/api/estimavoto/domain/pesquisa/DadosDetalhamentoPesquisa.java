package br.com.api.estimavoto.domain.pesquisa;

import java.time.LocalDate;

public record DadosDetalhamentoPesquisa(
        Long id,
        LocalDate data,
        String municipio,
        String estado,
        Long candidato,
        Integer quantidadeDeVotos

) {
    public DadosDetalhamentoPesquisa(Pesquisa p) {
        this(p.getId(),
                p.getData(),
                p.getMunicipio().getNome(),
                p.getEstado().getNome(),
                p.getCandidato().getId(),
                p.getQuantidadeDeVotos()
        );

    }
}