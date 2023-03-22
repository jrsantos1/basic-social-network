package br.com.jrsantos.socialnetwork.controllers.usuario;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import br.com.jrsantos.socialnetwork.models.Papel;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.PapelRepository;
import br.com.jrsantos.socialnetwork.repositories.UsuarioRepository;
import br.com.jrsantos.socialnetwork.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //@Autowired
    //private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioDto usuarioDto){
        Papel papel = papelRepository.findById(usuarioDto.papel()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Usuario usuario = new Usuario(usuarioDto, papel);
        usuarioService.salvar(usuario);
        //usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.consultarPorId(id);
        return ResponseEntity.ok(usuario);
    }
}
