package br.com.api.estimavoto.controller;

import br.com.api.estimavoto.importer.IbgeImporter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ibge")
@SecurityRequirement(name = "bearer-key")
public class IbgeController {

    @Autowired
    private IbgeImporter ibgeImporter;

    @PostMapping("/importar")
    public ResponseEntity<String> importarMunicipios(){
        ibgeImporter.importarMunicipios();

        return ResponseEntity.ok("Dados importados com sucesso!");
    }
}
