package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.InstiuicaoDto;
import br.com.jrsantos.socialnetwork.models.Instituicao;
import br.com.jrsantos.socialnetwork.repositories.InstituicaoRepository;
import br.com.jrsantos.socialnetwork.services.InstituicaoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid InstiuicaoDto instiuicaoDto, UriComponentsBuilder uriBuilder){
        Instituicao instituicao = instituicaoService.cadastrarInstituicao(instiuicaoDto);
        URI uri = uriBuilder.path("/instituicao/{id}").buildAndExpand(instituicao.getId()).toUri();
        return ResponseEntity.created(uri).body(instituicao);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity delete(Long id){
        instituicaoService.excluirInstituicao(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid InstiuicaoDto instiuicaoDto, Long id){
        Instituicao instituicao = instituicaoService.atualizarInstituicao(instiuicaoDto, id);
        return ResponseEntity.ok(instituicao);
    }

    @GetMapping
    public ResponseEntity obterPorId(Long id){
        Instituicao instituicao = instituicaoService.getInstituicao(id);
        return ResponseEntity.ok(instituicao);

    }

}
