package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.ContaDto;
import br.com.jrsantos.socialnetwork.dtos.ContaRetornoDto;
import br.com.jrsantos.socialnetwork.models.Conta;
import br.com.jrsantos.socialnetwork.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity salvar(@RequestBody @Valid ContaDto contaDto){
        Conta conta = contaService.cadastrar(contaDto);
        ContaRetornoDto contaRetornoDto = contaService.toContaRetornoResponse(conta);
        return ResponseEntity.ok(contaRetornoDto);
    }

}
