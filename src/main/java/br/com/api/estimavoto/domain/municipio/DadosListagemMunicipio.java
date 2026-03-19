package br.com.api.estimavoto.domain.municipio;

import br.com.api.estimavoto.domain.municipio.grupo.Grupo;

public record DadosListagemMunicipio(
        Long id,
        String nome,
        Grupo grupo
) {
    public DadosListagemMunicipio(Municipio m){
        this(m.getId(),
                m.getNome(),
                m.getGrupo());
    }
}
