package br.com.jrsantos.socialnetwork.models;

import br.com.jrsantos.socialnetwork.dtos.CursoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @NotNull
    private TipoCurso tipo;

    @OneToOne
    @NotNull
    private AreaCurso area;

    @OneToOne
    private SubAreaCurso sub_area;

    @Column(name = "duracao_em_semestres")
    @NotNull
    private Integer duracao_em_semestres;

    @OneToOne
    @NotNull
    private Instituicao instituicao;

}
