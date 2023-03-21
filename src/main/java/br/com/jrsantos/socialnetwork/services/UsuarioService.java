package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.UsuarioRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario salvar(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario consultarPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()){
            return usuario.get();
        }else {
            throw new RuntimeException("Usuário não existe");
        }
    }

}
