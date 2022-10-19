package br.sc.senai.sidtickets.controller;

import br.sc.senai.sidtickets.DTO.PassageiroDTO;
import br.sc.senai.sidtickets.model.entities.Passageiro;
import br.sc.senai.sidtickets.model.services.PassageiroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/sid/passageiros")
public class PassageiroController {
    private PassageiroService passageiroService;

    @PostMapping
    public ResponseEntity<Passageiro> save(@RequestBody @Valid PassageiroDTO passageiroDto) {
        if (passageiroService.existsById(passageiroDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Passageiro passageiro = new Passageiro();
        BeanUtils.copyProperties(passageiroDto, passageiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(passageiroService.save(passageiro));
    }

    @GetMapping
    public ResponseEntity<List<Passageiro>> findAll() {
        if (passageiroService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(passageiroService.findAll());
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Passageiro> findById(@PathVariable(value = "cpf") Long cpf) {
        Optional<Passageiro> passageiroOptional = passageiroService.findById(cpf);
        if (passageiroOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(passageiroOptional.get());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Passageiro> deleteById(@PathVariable(value = "cpf") Long cpf) {
        Optional<Passageiro> passageiroOptional = passageiroService.findById(cpf);
        if (passageiroOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        passageiroService.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Passageiro> update(@PathVariable(value = "cpf") Long cpf, @RequestBody @Valid PassageiroDTO passageiroDto) {
        if (passageiroService.existsById(cpf)) {
            Passageiro passageiro = new Passageiro();
            BeanUtils.copyProperties(passageiroDto, passageiro);
            passageiro.setCpf(cpf);
            return ResponseEntity.status(HttpStatus.OK).body(passageiroService.save(passageiro));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
