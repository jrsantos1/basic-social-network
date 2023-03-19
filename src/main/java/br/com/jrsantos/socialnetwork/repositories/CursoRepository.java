package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}