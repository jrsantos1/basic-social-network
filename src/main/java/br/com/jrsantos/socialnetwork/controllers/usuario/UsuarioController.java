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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //@Autowired

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioDto usuarioDto, UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioService.salvar(usuarioDto);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.consultarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid Usuario usuario){
        // usuarioService.atualizarUsuario()

        //todo refactor usuarioService e demais services, recendo id diretamente pelo request body e nao pela url

        return ResponseEntity.noContent().build();
    }

}
