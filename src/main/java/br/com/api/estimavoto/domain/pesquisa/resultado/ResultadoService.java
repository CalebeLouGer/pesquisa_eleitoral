package br.com.api.estimavoto.domain.pesquisa.resultado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository repository;

    public ResultadoPesquisa calcularResultado(Long pesquisaId) {

        List<Resultado> lista = repository.findByPesquisaId(pesquisaId);
        if (lista.isEmpty()) {
            throw new RuntimeException("Pesquisa não encontrada");
        }

        Map<String, Long> votos = new HashMap<>();
        for (Resultado r : lista) {
            String nomeCandidato = r.getCandidato().getNome();
            votos.put(nomeCandidato, votos.getOrDefault(nomeCandidato, 0L) + r.getQuantidadeVoto());
        }

        Resultado primeiro = lista.get(0);

        return new ResultadoPesquisa(
                primeiro.getPesquisa().getId(),
                primeiro.getPesquisa().getData().toString(),
                primeiro.getMunicipio().getNome(),
                primeiro.getMunicipio().getEstado().getNome(),
                votos
        );
    }
}