package br.sc.senai.sidtickets.repository;

import br.sc.senai.sidtickets.model.entities.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    Optional<Passageiro> findByCpf(Long cpf);
    boolean existsByCpf(Long cpf);

}
