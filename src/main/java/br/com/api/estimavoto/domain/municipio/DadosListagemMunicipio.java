package br.com.api.estimavoto.domain.municipio;

public record DadosListagemMunicipio(
        Long id,
        String nome
) {
    public DadosListagemMunicipio(Municipio m){
        this(m.getId(),
                m.getNome()
        );
    }
}
