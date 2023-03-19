package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.AreaCurso;
import br.com.jrsantos.socialnetwork.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaCursoRepository extends JpaRepository<AreaCurso, Long> {

}