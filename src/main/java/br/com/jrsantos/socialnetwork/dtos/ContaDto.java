package br.com.jrsantos.socialnetwork.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ContaDto(String cpf,
                       String nome,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate data_nascimento,
                       String sobre,
                       Long usuario_id,
                       Long curso_id,
                       byte[] cd_foto,
                       Long turma_id){
}
