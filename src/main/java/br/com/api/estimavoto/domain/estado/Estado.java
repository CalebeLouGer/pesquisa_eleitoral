package br.com.api.estimavoto.domain.estado;

import br.com.api.estimavoto.domain.municipio.Municipio;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "estados")
@Entity(name = "Estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;

    @OneToMany(mappedBy = "estado")
    private List<Municipio> municipios;

}
