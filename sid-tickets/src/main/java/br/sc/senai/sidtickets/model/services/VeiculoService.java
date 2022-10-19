package br.sc.senai.sidtickets.model.services;

import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.model.entities.TipoVeiculo;
import br.sc.senai.sidtickets.model.entities.Veiculo;
import br.sc.senai.sidtickets.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public Optional<Veiculo> findByAssentosVeiculo(AssentosVeiculo idAssento) {
        return veiculoRepository.findByAssentosVeiculo(idAssento);
    }

    public List<Veiculo> findByTipoVeiculo(TipoVeiculo tipoVeiculo) {
        return veiculoRepository.findByTipoVeiculo(tipoVeiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> findAllById(Iterable<Integer> integers) {
        return veiculoRepository.findAllById(integers);
    }

    public <S extends Veiculo> S save(S entity) {
        return veiculoRepository.save(entity);
    }

    public Optional<Veiculo> findById(Integer integer) {
        return veiculoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return veiculoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        veiculoRepository.deleteById(integer);
    }
}
