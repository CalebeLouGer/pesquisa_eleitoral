package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.domain.candidato.CandidatoRepository;
import br.com.api.estimavoto.domain.estado.EstadoRepository;
import br.com.api.estimavoto.domain.municipio.MunicipioRepository;
import br.com.api.estimavoto.domain.pesquisa.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pesquisa")
@SecurityRequirement(name = "bearer-key")
public class PesquisaController {

    @Autowired
    private PesquisaRepository pesquisaRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping
    public ResponseEntity<Page<DadosListagemPesquisa>> listar(@PageableDefault(sort = {"id"}, size = 10) Pageable pageable){
        var page = pesquisaRepository.findAll(pageable).map(DadosListagemPesquisa::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPesquisa dados, UriComponentsBuilder uriBuilder) {
        var municipio = municipioRepository.getReferenceById(dados.municipioId());
        var estado = estadoRepository.getReferenceById(dados.estadoId());
        var candidato = candidatoRepository.getReferenceById(dados.candidatoId());

        var pesquisa = new Pesquisa(dados, municipio, estado, candidato);
        pesquisaRepository.save(pesquisa);
        var pesquisaDetalhada = pesquisaRepository.buscarDetalhado(pesquisa.getId()).get();

        var uri = uriBuilder.path("/pesquisa/{id}").buildAndExpand(pesquisa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPesquisa(pesquisaDetalhada));
    }
}
