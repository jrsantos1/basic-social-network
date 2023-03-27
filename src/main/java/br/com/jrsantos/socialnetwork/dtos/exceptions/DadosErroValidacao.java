package br.com.jrsantos.socialnetwork.dtos.exceptions;

import org.springframework.validation.FieldError;

public record DadosErroValidacao(String nome, String mensagem) {
    public DadosErroValidacao(FieldError erro) {
        this(erro.getField(), erro.getDefaultMessage());
    }
}
