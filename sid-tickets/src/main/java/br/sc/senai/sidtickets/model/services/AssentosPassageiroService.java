package br.sc.senai.sidtickets.model.services;

import br.sc.senai.sidtickets.model.entities.AssentosPassageiro;
import br.sc.senai.sidtickets.repository.AssentosPassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssentosPassageiroService {
    @Autowired
    AssentosPassageiroRepository assentosPassageiroRepository;

    public List<AssentosPassageiro> findAll() {
        return assentosPassageiroRepository.findAll();
    }

    public <S extends AssentosPassageiro> S save(S entity) {
        return assentosPassageiroRepository.save(entity);
    }

    public Optional<AssentosPassageiro> findById(Integer integer) {
        return assentosPassageiroRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return assentosPassageiroRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        assentosPassageiroRepository.deleteById(integer);
    }
}
