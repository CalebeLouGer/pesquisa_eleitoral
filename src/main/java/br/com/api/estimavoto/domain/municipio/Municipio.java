package br.com.api.estimavoto.domain.municipio;

import br.com.api.estimavoto.domain.estado.Estado;
import br.com.api.estimavoto.domain.pesquisa.resultado.Resultado;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "municipios")
@Entity(name = "Municipio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Municipio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long populacao;
    private int grupo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "municipio")
    private List<Resultado> resultados;

}
