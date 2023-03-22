package br.com.jrsantos.socialnetwork.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TurmaCadastroDto(
        @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate data,
        String letra,
        String semestre,
        Long curso_id
        ) {
}
