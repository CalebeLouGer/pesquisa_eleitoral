package br.com.api.estimavoto.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "municipio")
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
    private int populacao;
    private int grupo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}
