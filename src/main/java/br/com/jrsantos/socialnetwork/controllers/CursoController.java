package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.CursoDto;
import br.com.jrsantos.socialnetwork.models.*;
import br.com.jrsantos.socialnetwork.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CursoDto cursoDto, UriComponentsBuilder uriBuilder){

        Curso curso = cursoService.cadastrar(cursoDto);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(curso);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Curso curso = cursoService.consultarPorId(id);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid CursoDto cursoDto, @PathVariable Long id){
        Curso curso = cursoService.atualizarCurso(cursoDto, id);
        return ResponseEntity.ok(curso);
    }


}
