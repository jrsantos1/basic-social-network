package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import br.com.jrsantos.socialnetwork.models.Papel;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.PapelRepository;
import br.com.jrsantos.socialnetwork.repositories.UsuarioRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;
    public Usuario salvar(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuarioCadastroTemplate(usuarioDto, usuario);
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

    public Usuario atualizarUsuario(UsuarioDto usuarioDto, Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioCadastroTemplate(usuarioDto, usuario);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public void excluirUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario usuarioCadastroTemplate(UsuarioDto usuarioDto, Usuario usuario){
        Papel papel = papelRepository.getReferenceById(usuarioDto.papel());
        usuario.setPapel(papel);
        usuario.setEmail(usuarioDto.email());
        usuario.setSenha(usuarioDto.senha());
        return usuario;
    }

}
