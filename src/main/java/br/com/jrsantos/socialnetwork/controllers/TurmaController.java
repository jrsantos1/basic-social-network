package br.com.jrsantos.socialnetwork.controllers;


import br.com.jrsantos.socialnetwork.dtos.TurmaCadastroDto;
import br.com.jrsantos.socialnetwork.models.Turma;
import br.com.jrsantos.socialnetwork.services.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid TurmaCadastroDto turmaCadastroDto, UriComponentsBuilder uriBuilder){
        Turma turma = turmaService.cadastrar(turmaCadastroDto);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(turma);
    }

}
