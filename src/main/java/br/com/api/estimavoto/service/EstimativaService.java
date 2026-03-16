package br.com.api.estimavoto.service;

import br.com.api.estimavoto.model.Entrevista;
import br.com.api.estimavoto.repository.EntrevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstimativaService {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    public Map<Long, Long> calcularResultado(Long pesquisaId){

        List<Entrevista> entrevistas = entrevistaRepository.findAll();

        return entrevistas.stream().collect(Collectors.groupingBy(e -> e.getCandidato().getId(), Collectors.counting()));
    }
}
