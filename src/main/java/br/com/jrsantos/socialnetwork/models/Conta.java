package br.com.jrsantos.socialnetwork.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "cpf")
    private String cpf;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;

    @Column(name = "sobre")
    private String sobre;

    @OneToOne
    @NotNull
    private Usuario usuario;

    @OneToOne
    @NotNull
    private Instituicao instituicao;

    @OneToOne
    @NotNull
    private Curso curso;

    @OneToOne
    private Foto foto;

    @OneToOne
    @NotNull
    private Turma turma;

}
