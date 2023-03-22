package br.com.jrsantos.socialnetwork.models;

import br.com.jrsantos.socialnetwork.util.enums.Letra;
import br.com.jrsantos.socialnetwork.util.enums.Semestre;
import jakarta.persistence.*;
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
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @NotNull
    private Curso curso;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ano")
    @NotNull
    private LocalDate data;

    @Column(name = "semestre")
    @NotNull
    private String semestre;

    @Column(name = "letra")
    @NotNull
    private String letra;


}
