package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.service.EstimativaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pesquisa")
@SecurityRequirement(name = "bearer-key")
public class PesquisaController {

    @Autowired
    private EstimativaService estimativaService;

    @GetMapping("/{id}/resultado")
    public ResponseEntity<Map<Long, Long>> resultado(@PathVariable Long id){
        Map<Long, Long> resultado = estimativaService.calcularResultado(id);

        return ResponseEntity.ok(resultado);
    }

}
