package br.sc.senai.sidtickets.controller;

import br.sc.senai.sidtickets.model.entities.Passagem;
import br.sc.senai.sidtickets.model.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sid/passagem")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @GetMapping
    public ResponseEntity<List<Passagem>> findAll() {
        List<Passagem> list = passagemService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{passagem_id}")
    public ResponseEntity<Object> findById(@PathVariable Integer passagem_id) {

        if (!passagemService.existsById(passagem_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem não encontrada");
        }

        Passagem passagem = passagemService.findById(passagem_id);
        return ResponseEntity.ok().body(passagem);
    }

    @PostMapping
    public ResponseEntity<Passagem> insert(@RequestBody @Valid Passagem passagem) {
        passagem = passagemService.insert(passagem);
        return ResponseEntity.ok().body(passagem);
    }

}
