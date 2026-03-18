package br.com.api.estimavoto.domain.pesquisa;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPesquisa(
        @NotNull
        LocalDate data
) {
}
