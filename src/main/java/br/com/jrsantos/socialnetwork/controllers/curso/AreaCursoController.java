package br.com.jrsantos.socialnetwork.controllers.curso;

import br.com.jrsantos.socialnetwork.dtos.curso.AreaCursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.CursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.SubAreaCursoDto;
import br.com.jrsantos.socialnetwork.models.AreaCurso;
import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.SubAreaCurso;
import br.com.jrsantos.socialnetwork.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.geom.Area;
import java.net.URI;

@RestController
@RequestMapping("/curso/area_curso")
public class AreaCursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid AreaCursoDto areaCursoDto, UriComponentsBuilder uriBuilder){

        AreaCurso areaCurso = cursoService.cadastrarAreaCurso(areaCursoDto);
        URI uri = uriBuilder.path("curso/area_curso/{id}").buildAndExpand(areaCurso.getId()).toUri();
        return ResponseEntity.created(uri).body(areaCurso);
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        AreaCurso areaCurso = cursoService.consultarAreaCursoPorId(id);
        return ResponseEntity.ok(areaCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        cursoService.excluirAreaCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid AreaCursoDto areaCursoDto, @PathVariable Long id){
        AreaCurso areaCurso = cursoService.atualizarAreaCurso(areaCursoDto, id);
        return ResponseEntity.ok(areaCurso);
    }


}
