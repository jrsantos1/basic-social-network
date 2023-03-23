package br.com.jrsantos.socialnetwork.controllers;


import br.com.jrsantos.socialnetwork.dtos.TurmaCadastroDto;
import br.com.jrsantos.socialnetwork.models.Turma;
import br.com.jrsantos.socialnetwork.services.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid TurmaCadastroDto turmaCadastroDto, Long id){
        Turma turma = turmaService.atualizarTurma(turmaCadastroDto, id);
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(Long id){
        turmaService.excluirTurma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity getTurma(Long id){
        Turma turma = turmaService.getTurma(id);
        return ResponseEntity.ok(turma);
    }

}
