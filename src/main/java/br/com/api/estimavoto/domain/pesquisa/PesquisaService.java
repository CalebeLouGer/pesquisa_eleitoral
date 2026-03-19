package br.com.api.estimavoto.domain.pesquisa;

import br.com.api.estimavoto.domain.estado.Estado;
import br.com.api.estimavoto.domain.response.EstadoResponseDTO;
import br.com.api.estimavoto.domain.response.MunicipioResponseDTO;
import br.com.api.estimavoto.domain.response.ResultadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PesquisaService {

    @Autowired
    private PesquisaRepository repository;

    public List<EstadoResponseDTO> buscarResultadosAgrupados() {

        List<Pesquisa> pesquisas = repository.findAll();

        Map<Estado, Map<String, List<Pesquisa>>> agrupado =
                pesquisas.stream()
                        .collect(Collectors.groupingBy(
                                Pesquisa::getEstado,
                                Collectors.groupingBy(p -> p.getMunicipio().getNome())
                        ));

        List<EstadoResponseDTO> resposta = new ArrayList<>();

        for (Estado estado : agrupado.keySet()) {

            Map<String, List<Pesquisa>> municipiosMap = agrupado.get(estado);

            List<MunicipioResponseDTO> municipiosDTO = new ArrayList<>();

            for (String nomeMunicipio : municipiosMap.keySet()) {

                List<Pesquisa> lista = municipiosMap.get(nomeMunicipio);

                List<ResultadoResponseDTO> resultados = lista.stream()
                        .map(p -> new ResultadoResponseDTO(
                                p.getId(),
                                p.getData(),
                                p.getMunicipio().getNome(),
                                p.getEstado().getNome(),
                                p.getCandidato().getId(),
                                p.getQuantidadeDeVotos()
                        ))
                        .toList();

                municipiosDTO.add(new MunicipioResponseDTO(nomeMunicipio, resultados));
            }

            resposta.add(new EstadoResponseDTO(
                    estado.getId(),
                    estado.getNome(),
                    estado.getSigla(),
                    municipiosDTO
            ));
        }

        return resposta;
    }
}

