package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.domain.pesquisa.PesquisaService;
import br.com.api.estimavoto.domain.response.EstadoResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resultados")
@SecurityRequirement(name = "bearer-key")
public class ResultadoController {

    @Autowired
    private PesquisaService service;

    @GetMapping
    public List<EstadoResponseDTO> listar() {
        return service.buscarResultadosAgrupados();
    }
}
