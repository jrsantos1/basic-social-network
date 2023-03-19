package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.CursoDto;
import br.com.jrsantos.socialnetwork.models.*;
import br.com.jrsantos.socialnetwork.repositories.*;
import br.com.jrsantos.socialnetwork.services.CursoService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.EntityNotFoundException;
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
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    @Autowired
    private AreaCursoRepository areaCursoRepository;

    @Autowired
    private SubAreaCursoRepository subAreaCursoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CursoDto cursoDto, UriComponentsBuilder uriBuilder){

        TipoCurso tipoCurso = tipoCursoRepository.findById(cursoDto.tipo()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Instituicao instituicao = instituicaoRepository.findById(cursoDto.instituicao()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        AreaCurso areaCurso = areaCursoRepository.findById(cursoDto.area()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        SubAreaCurso subAreaCurso = subAreaCursoRepository.findById(cursoDto.subArea()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Curso curso = cursoService.toCursoResponse(cursoDto, tipoCurso, instituicao, areaCurso, subAreaCurso);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(curso.getId()).toUri();
        cursoRepository.save(curso);

        return ResponseEntity.created(uri).body(curso);

    }
}
