package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.ContaDto;
import br.com.jrsantos.socialnetwork.dtos.ContaRetornoDto;
import br.com.jrsantos.socialnetwork.models.Conta;
import br.com.jrsantos.socialnetwork.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable Long id){
        Conta conta = contaService.consultarPorId(id);
        return ResponseEntity.ok(conta);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid ContaDto contaDto, UriComponentsBuilder uriBuilder){
        Conta conta = contaService.cadastrar(contaDto);
        ContaRetornoDto contaRetornoDto = contaService.toContaRetornoResponse(conta);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(uri).body(contaRetornoDto);
    }
    @PostMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid ContaDto contaDto, UriComponentsBuilder uriBuilder){
        Conta conta = contaService.atualizar(contaDto, id);
        ContaRetornoDto contaRetornoDto = contaService.toContaRetornoResponse(conta);
        URI uri = uriBuilder.path("curso/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(uri).body(contaRetornoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(Long id){
        Conta conta = contaService.excluir(id);
        return ResponseEntity.ok(conta);
    }

}
