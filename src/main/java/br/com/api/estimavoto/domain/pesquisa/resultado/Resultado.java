package br.com.api.estimavoto.domain.pesquisa.resultado;

import br.com.api.estimavoto.domain.candidato.Candidato;
import br.com.api.estimavoto.domain.pesquisa.Pesquisa;
import br.com.api.estimavoto.domain.municipio.Municipio;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "resultados")
@Entity(name = "Resultado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resultado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pesquisa_id", nullable = false)
    private Pesquisa pesquisa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id", nullable = false)
    private Candidato candidato;

    private Long quantidadeVoto;

}
