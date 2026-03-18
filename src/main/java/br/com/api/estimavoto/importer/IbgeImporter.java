package br.com.api.estimavoto.importer;

import br.com.api.estimavoto.domain.estado.Estado;
import br.com.api.estimavoto.domain.municipio.Municipio;
import br.com.api.estimavoto.domain.estado.EstadoRepository;
import br.com.api.estimavoto.domain.municipio.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class IbgeImporter {
    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public void importarMunicipios() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";

        ResponseEntity<List<Map<String,Object>>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        List<Map<String,Object>> municipios = response.getBody();

        for(Map<String,Object> municipioJson : municipios){

            String nomeMunicipio = (String) municipioJson.get("nome");

            Map microrregiao = (Map) municipioJson.get("microrregiao");
            Map mesorregiao = (Map) microrregiao.get("mesorregiao");
            Map uf = (Map) mesorregiao.get("UF");

            String nomeEstado = (String) uf.get("nome");
            String sigla = (String) uf.get("sigla");

            Estado estado = estadoRepository
                    .findBySigla(sigla)
                    .orElseGet(() -> {

                        Estado novo = new Estado();
                        novo.setNome(nomeEstado);
                        novo.setSigla(sigla);

                        return estadoRepository.save(novo);
                    });

            Municipio municipio = new Municipio();

            municipio.setNome(nomeMunicipio);
            municipio.setEstado(estado);
            municipio.setPopulacao(gerarPopulacaoFake());

            municipioRepository.save(municipio);
        }

    }
    private Long gerarPopulacaoFake() {
        return (long) (Math.random() * 1_500_000);
    }

}