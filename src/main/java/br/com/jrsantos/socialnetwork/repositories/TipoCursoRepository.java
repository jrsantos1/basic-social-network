package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.Instituicao;
import br.com.jrsantos.socialnetwork.models.TipoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso, Long> {

}