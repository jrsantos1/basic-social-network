package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario salvar(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

}
