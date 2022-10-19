package br.sc.senai.sidtickets.model.services;

import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.repository.AssentosVeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssentosVeiculoService {
    private AssentosVeiculoRepository assentosVeiculoRepository;

    public AssentosVeiculoService(AssentosVeiculoRepository assentosVeiculoRepository) {
        this.assentosVeiculoRepository = assentosVeiculoRepository;
    }

    public List<AssentosVeiculo> findAll() {
        return assentosVeiculoRepository.findAll(); }

    public <S extends AssentosVeiculo> S save(S entity) {
        return assentosVeiculoRepository.save(entity);
    }

    public AssentosVeiculo findById(Long idAssentosVeiculo) {
        return assentosVeiculoRepository.findById(idAssentosVeiculo).get();
    }

    public List<AssentosVeiculo> findByColunas(Character coluna) {
        return assentosVeiculoRepository.findByColunas(coluna);
    }

    public List<AssentosVeiculo> findByQtdAssentosColunas(Integer qtdAssentosColunas) {
        return assentosVeiculoRepository.findByQtdAssentosColunas(qtdAssentosColunas);
    }

    public void deleteById(Long idAssentosVeiculo) {
        assentosVeiculoRepository.deleteById(idAssentosVeiculo);
    }

    public boolean existsById(Long idAssentosVeiculo) {
        return assentosVeiculoRepository.existsById(idAssentosVeiculo);
    }

}
