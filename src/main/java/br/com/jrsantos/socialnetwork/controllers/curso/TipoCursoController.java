package br.com.jrsantos.socialnetwork.controllers.curso;

import br.com.jrsantos.socialnetwork.dtos.curso.CursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.TipoCursoDto;
import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.TipoCurso;
import br.com.jrsantos.socialnetwork.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso/tipo_curso")
public class TipoCursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid TipoCursoDto tipoCursoDto, UriComponentsBuilder uriBuilder){

        TipoCurso tipoCurso = cursoService.cadastrarTipoCurso(tipoCursoDto);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(tipoCurso.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoCurso);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        TipoCurso tipoCurso = cursoService.consultarTipoCursoId(id);
        return ResponseEntity.ok(tipoCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        cursoService.excluirTipoCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid TipoCursoDto tipoCursoDto, @PathVariable Long id){
        TipoCurso tipoCurso = cursoService.atualizarTipoCurso(tipoCursoDto, id);
        return ResponseEntity.ok(tipoCurso);
    }


}
