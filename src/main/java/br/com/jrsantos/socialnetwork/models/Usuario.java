package br.com.jrsantos.socialnetwork.models;

import br.com.jrsantos.socialnetwork.dtos.UsuarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
