package br.com.jrsantos.socialnetwork.models;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@EqualsAndHashCode
@Table(name = "usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "A senha deve conter no mínimo 8 caracteres, uma letra maiúscula, uma letra minúscula e um caractere especial")
    @Column(name = "senha")
    private String senha;

    @OneToOne
    private Papel papel;

    public Usuario(UsuarioDto usuarioDto, Papel papel){
        this.setEmail(usuarioDto.email());
        this.setSenha(usuarioDto.senha());
        this.setPapel(papel);
    }

}
