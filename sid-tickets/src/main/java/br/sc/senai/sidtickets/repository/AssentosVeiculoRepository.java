package br.sc.senai.sidtickets.repository;

import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssentosVeiculoRepository extends JpaRepository<AssentosVeiculo, Long> {

    List<AssentosVeiculo> findByColunas(Character coluna);
    List<AssentosVeiculo> findByQtdAssentosColunas(Integer qtdAssentosColunas);
}
