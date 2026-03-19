package br.com.api.estimavoto.domain.estado;

public record DadosListagemEstados(
        Long id,
        String nome,
        String sigla
) {
    public DadosListagemEstados(Estado e){
        this(e.getId(),
                e.getNome(),
                e.getSigla()
        );
    }
}
