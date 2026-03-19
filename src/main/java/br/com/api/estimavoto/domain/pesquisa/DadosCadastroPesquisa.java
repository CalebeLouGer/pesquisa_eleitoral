package br.com.api.estimavoto.domain.pesquisa;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPesquisa(
        @NotNull
        Long municipioId,

        @NotNull
        Long estadoId,

        @NotNull
        Long candidatoId,

        @NotNull
        Integer quantidadeDeVotos

) {
}
