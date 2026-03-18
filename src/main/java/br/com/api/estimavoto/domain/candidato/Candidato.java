package br.com.api.estimavoto.domain.candidato;

import br.com.api.estimavoto.domain.pesquisa.resultado.Resultado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "candidatos")
@Entity(name = "Candidato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "candidato")
    private List<Resultado> resultados;
}
