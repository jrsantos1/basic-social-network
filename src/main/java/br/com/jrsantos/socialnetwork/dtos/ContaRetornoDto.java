package br.com.jrsantos.socialnetwork.dtos;

import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.Turma;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ContaRetornoDto(String cpf,
                       String nome,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data_nascimento,
                       String sobre,
                       Curso curso,
                       Turma turma){
}
