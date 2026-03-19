package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.domain.municipio.grupo.GrupoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
@SecurityRequirement(name = "bearer-key")
public class MunicipioController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping("/classificar")
    public void classificar() {
        grupoService.classificarMunicipios();
    }

}
