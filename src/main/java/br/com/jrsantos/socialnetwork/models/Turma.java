package br.com.jrsantos.socialnetwork.models;

import br.com.jrsantos.socialnetwork.util.enums.Letra;
import br.com.jrsantos.socialnetwork.util.enums.Semestre;
import jakarta.persistence.*;
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
    private Curso curso;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ano")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(name = "semestre")
    private Semestre semestre;

    @Enumerated(EnumType.STRING)
    @Column(name = "letra")
    private Letra letra;


}
