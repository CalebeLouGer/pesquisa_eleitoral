package br.com.api.estimavoto.importer;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Service
public class PesquisaImporter {
    public void importar(File arquivo) throws Exception {

        BufferedReader reader =
                new BufferedReader(new FileReader(arquivo));

        String linha;

        while((linha = reader.readLine()) != null){

            String[] dados = linha.split(",");

            String municipio = dados[2];
            String estado = dados[3];
            Long candidatoId = Long.parseLong(dados[4]);

        }

    }
}
