package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.FotoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.CursoDto;
import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.Foto;
import br.com.jrsantos.socialnetwork.services.CursoService;
import br.com.jrsantos.socialnetwork.services.FotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foto")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid FotoDto fotoDto, UriComponentsBuilder uriBuilder){

        Foto foto = fotoService.salvar(fotoDto);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(foto.getId()).toUri();
        return ResponseEntity.created(uri).body(foto);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Foto foto = fotoService.getFoto(id);
        return ResponseEntity.ok(foto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        fotoService.excluirFoto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid FotoDto fotoDto, @PathVariable Long id){
        Foto foto = fotoService.atualizarFoto(fotoDto, id);
        return ResponseEntity.ok(foto);
    }


}
