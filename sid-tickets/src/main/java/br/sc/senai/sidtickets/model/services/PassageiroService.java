package br.sc.senai.sidtickets.model.services;

import br.sc.senai.sidtickets.model.entities.Passageiro;
import br.sc.senai.sidtickets.repository.PassageiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {
    private PassageiroRepository passageiroRepository;

    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }

    public List<Passageiro> findAll() {
        return passageiroRepository.findAll();
    }

    public boolean existsById(Long cpf) {
        return passageiroRepository.existsById(cpf);
    }

    public <S extends Passageiro> S save(S entity) {
        return passageiroRepository.save(entity);
    }

    public Optional<Passageiro> findById(Long cpf) {
        return passageiroRepository.findById(cpf);
    }

    public Optional<Passageiro> findByCpf(Long cpf) {
        return passageiroRepository.findByCpf(cpf);
    }

    public void deleteById(Long cpf) {
        passageiroRepository.deleteById(cpf);
    }

    public boolean existsByCpf(Long cpf) {
        return passageiroRepository.existsByCpf(cpf);
    }
}
