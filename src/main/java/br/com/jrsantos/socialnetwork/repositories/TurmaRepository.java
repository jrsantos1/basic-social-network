package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.AreaCurso;
import br.com.jrsantos.socialnetwork.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}