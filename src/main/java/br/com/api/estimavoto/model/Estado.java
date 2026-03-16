package br.com.api.estimavoto.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "estado")
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

}
