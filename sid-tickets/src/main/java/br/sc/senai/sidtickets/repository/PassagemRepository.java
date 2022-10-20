package br.sc.senai.sidtickets.repository;

import br.sc.senai.sidtickets.model.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}

