package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public Usuario salvar(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
//        usuario.setEmail(usuarioDto.email());
//        usuario.setSenha(usuarioDto.senha());
//        usuario.setPapel(usuarioDto.papel());
//        usuarioRepository.save(usuario);
        return usuario;
    }

}
