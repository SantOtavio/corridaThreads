package br.sc.senai.sidtickets.repository;

import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.model.entities.TipoVeiculo;
import br.sc.senai.sidtickets.model.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Optional<Veiculo> findByAssentosVeiculo(AssentosVeiculo idAssento);

    List<Veiculo> findByTipoVeiculo(TipoVeiculo tipoVeiculo);


}
