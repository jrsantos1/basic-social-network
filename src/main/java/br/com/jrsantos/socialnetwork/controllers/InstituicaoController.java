package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.InstiuicaoDto;
import br.com.jrsantos.socialnetwork.models.Instituicao;
import br.com.jrsantos.socialnetwork.repositories.InstituicaoRepository;
import br.com.jrsantos.socialnetwork.services.InstituicaoService;
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
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid InstiuicaoDto instiuicaoDto, UriComponentsBuilder uriBuilder){
        Instituicao instituicao = instituicaoService.toInstituicaoResponse(instiuicaoDto);
        instituicaoRepository.save(instituicao);

        URI uri = uriBuilder.path("/instituicao/{id}").buildAndExpand(instituicao.getId()).toUri();

        return ResponseEntity.created(uri).body(instituicao);
    }

}
