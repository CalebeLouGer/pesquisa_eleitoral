package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.domain.estado.DadosDetalhamentoEstados;
import br.com.api.estimavoto.domain.estado.DadosListagemEstados;
import br.com.api.estimavoto.domain.estado.EstadoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
@SecurityRequirement(name = "bearer-key")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemEstados>> listar(@PageableDefault(sort = {"id"}, size = 10) Pageable pageable){
        var page = estadoRepository.findAll(pageable).map(DadosListagemEstados::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var estado = estadoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEstados(estado));
    }
}
