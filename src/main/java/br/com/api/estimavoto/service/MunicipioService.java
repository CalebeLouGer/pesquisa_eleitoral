package br.com.api.estimavoto.service;

import org.springframework.stereotype.Service;

@Service
public class MunicipioService {
    public int calcularGrupo(int populacao){

        if(populacao <= 20000)
            return 1;

        if(populacao <= 100000)
            return 2;

        if(populacao <= 1000000)
            return 3;

        return 4;
    }

}
