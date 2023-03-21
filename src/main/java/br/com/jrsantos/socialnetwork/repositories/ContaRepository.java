package br.com.jrsantos.socialnetwork.repositories;

import br.com.jrsantos.socialnetwork.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
