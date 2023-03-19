package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
