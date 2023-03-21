package br.com.jrsantos.socialnetwork.controllers;
import br.com.jrsantos.socialnetwork.dtos.PostagemDto;
import br.com.jrsantos.socialnetwork.models.*;
import br.com.jrsantos.socialnetwork.services.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;


    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid PostagemDto postagemDto, UriComponentsBuilder uriBuilder){

        Postagem postagem = postagemService.cadastrar(postagemDto);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(postagem).toUri();
        return ResponseEntity.created(uri).body(postagem);

    }

    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Postagem postagem = postagemService.consultarPorId(id);
        return ResponseEntity.ok(postagem);
    }


}
