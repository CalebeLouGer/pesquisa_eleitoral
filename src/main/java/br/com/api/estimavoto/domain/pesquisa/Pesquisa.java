package br.com.api.estimavoto.domain.pesquisa;

import br.com.api.estimavoto.domain.pesquisa.resultado.Resultado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "pesquisas")
@Entity(name = "Pesquisa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pesquisa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @OneToMany(mappedBy = "pesquisa")
    private List<Resultado> resultados;

    public Pesquisa(DadosCadastroPesquisa dados) {
        this.data = dados.data();
    }
}