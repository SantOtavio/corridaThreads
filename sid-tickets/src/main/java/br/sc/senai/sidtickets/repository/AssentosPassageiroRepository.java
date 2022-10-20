package br.sc.senai.sidtickets.repository;

import br.sc.senai.sidtickets.model.entities.AssentosPassageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentosPassageiroRepository extends JpaRepository<AssentosPassageiro, Integer> {
    
}
