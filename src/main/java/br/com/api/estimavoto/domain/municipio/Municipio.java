package br.com.api.estimavoto.domain.municipio;

import br.com.api.estimavoto.domain.estado.Estado;
import br.com.api.estimavoto.domain.municipio.grupo.Grupo;
import jakarta.persistence.*;
import lombok.*;

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

    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}
