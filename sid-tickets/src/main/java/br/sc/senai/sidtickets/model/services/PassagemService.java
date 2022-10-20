package br.sc.senai.sidtickets.model.services;

import br.sc.senai.sidtickets.model.entities.Passagem;
import br.sc.senai.sidtickets.repository.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;


    public List<Passagem> findAll() {
        return passagemRepository.findAll();
    }

    public Passagem insert(Passagem passagem) {
        return passagemRepository.save(passagem);
    }

    public Passagem findById(Integer passagem_id) {
        return passagemRepository.findById(passagem_id).get();
    }

    public boolean existsById(Integer passagem_id) {
        return passagemRepository.existsById(passagem_id);
    }
}
