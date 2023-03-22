package br.com.jrsantos.socialnetwork.controllers.curso;

import br.com.jrsantos.socialnetwork.dtos.curso.CursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.SubAreaCursoDto;
import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.SubAreaCurso;
import br.com.jrsantos.socialnetwork.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso/sub_area_curso")
public class SubAreaCursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid SubAreaCursoDto subAreaCursoDto, UriComponentsBuilder uriBuilder){

        SubAreaCurso subAreaCurso = cursoService.cadastrarSubAreaCurso(subAreaCursoDto);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(subAreaCurso.getId()).toUri();
        return ResponseEntity.created(uri).body(subAreaCurso);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        SubAreaCurso subAreaCurso = cursoService.consultarSubAreaPorId(id);
        return ResponseEntity.ok(subAreaCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        cursoService.excluirSubAreaCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid SubAreaCursoDto subAreaCursoDto, @PathVariable Long id){
        SubAreaCurso subAreaCurso = cursoService.atualizarSubAreaCurso(subAreaCursoDto, id);
        return ResponseEntity.ok(subAreaCurso);
    }


}
