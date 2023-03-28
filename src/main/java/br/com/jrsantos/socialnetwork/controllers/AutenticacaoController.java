package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.dtos.DadosAutenticacaoDto;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados) {

        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = authManager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((Usuario) auth.getPrincipal()));
    }



}
