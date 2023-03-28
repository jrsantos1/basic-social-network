package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        try{
            var algoritmo = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API Rede social")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        }catch (Exception e){
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
