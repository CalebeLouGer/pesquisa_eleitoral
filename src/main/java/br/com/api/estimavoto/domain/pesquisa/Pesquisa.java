package br.com.api.estimavoto.domain.pesquisa;

import br.com.api.estimavoto.domain.candidato.Candidato;
import br.com.api.estimavoto.domain.estado.Estado;
import br.com.api.estimavoto.domain.municipio.Municipio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id", nullable = false)
    private Candidato candidato;

    @Column(name = "quantidade_voto", nullable = false)
    private Integer quantidadeDeVotos;

    public Pesquisa(DadosCadastroPesquisa dados, Municipio municipio, Estado estado, Candidato candidato){
        this.data = LocalDate.now();
        this.municipio = municipio;
        this.estado = estado;
        this.candidato = candidato;
        this.quantidadeDeVotos = dados.quantidadeDeVotos();
    }
}