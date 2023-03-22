package br.com.jrsantos.socialnetwork.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sub_area_curso")
public class SubAreaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private AreaCurso area_curso;

    @NotBlank
    @NotNull
    @Column(name = "nome")
    private String nomeSubArea;

    @NotBlank
    @NotNull
    @Column(name = "ds_sub_area")
    private String descricao;
}
