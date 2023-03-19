package br.com.jrsantos.socialnetwork.dtos;

import br.com.jrsantos.socialnetwork.models.Papel;

public record UsuarioDto(String email, String senha, Long papel) {

}
