package br.com.jrsantos.socialnetwork.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instituicao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instituicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "unidade")
    @NotNull
    private String unidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;
}
