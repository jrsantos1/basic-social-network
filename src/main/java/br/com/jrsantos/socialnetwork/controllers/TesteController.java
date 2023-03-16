package br.com.jrsantos.socialnetwork.controllers;

import br.com.jrsantos.socialnetwork.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {
    @GetMapping
    public ResponseEntity<User> getTest(){

        User user = new User("Jhonatan", "123", "jhonatanjonh@outlook.com");

        return ResponseEntity.ok().body(user);
    }
}
