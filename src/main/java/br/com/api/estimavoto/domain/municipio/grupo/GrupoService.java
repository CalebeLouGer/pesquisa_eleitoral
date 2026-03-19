package br.com.api.estimavoto.domain.municipio.grupo;

import br.com.api.estimavoto.domain.municipio.Municipio;
import br.com.api.estimavoto.domain.municipio.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public void classificarMunicipios() {

        List<Municipio> municipios = municipioRepository.findAll();

        for (Municipio m : municipios) {
            Long populacao = m.getPopulacao();
            Grupo grupo = classificar(populacao);
            m.setGrupo(grupo);
        }

        municipioRepository.saveAll(municipios);
    }

    private Grupo classificar(Long populacao) {
        if (populacao <= 20000) {
            return Grupo.A;
        } else if (populacao > 20000 && populacao < 100000) {
            return Grupo.B;
        } else if (populacao > 100000 && populacao < 1000000) {
            return Grupo.C;
        } else {
            return Grupo.D;
        }
    }
}