package br.sc.senai.sidtickets.controller;

import br.sc.senai.sidtickets.DTO.AssentosVeiculoDTO;
import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.model.services.AssentosVeiculoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sid/assentosVeiculos")
public class AssentosVeiculoController {
    AssentosVeiculoService assentosVeiculoService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(assentosVeiculoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AssentosVeiculoDTO assentosVeiculoDTO) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Character> colunas = null;

        for (int i = 0; i < assentosVeiculoDTO.getQtdColunas(); i++) {
            colunas.add(alfabeto.charAt(i));
        }

        AssentosVeiculo assentosVeiculo = new AssentosVeiculo();
        assentosVeiculo.setColunas(colunas);
        BeanUtils.copyProperties(assentosVeiculoDTO, assentosVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(assentosVeiculoService.save(assentosVeiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long id, @RequestBody @Valid AssentosVeiculoDTO assentosVeiculoDTO) {
        if (!assentosVeiculoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assento não encontrado!");
        }
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Character> colunas = null;

        for (int i = 0; i < assentosVeiculoDTO.getQtdColunas(); i++) {
            colunas.add(alfabeto.charAt(i));
        }

        AssentosVeiculo assentosVeiculo = new AssentosVeiculo();
        assentosVeiculo.setColunas(colunas);
        BeanUtils.copyProperties(assentosVeiculoDTO, assentosVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(assentosVeiculoService.save(assentosVeiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
        if (!assentosVeiculoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assento não encontrado!");
        }
        assentosVeiculoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Assento deletado com sucesso!");
    }

    @GetMapping("/{coluna}")
    public ResponseEntity<Object> findByColuna(@PathVariable(name = "coluna") Character coluna) {
        List<AssentosVeiculo> assentosVeiculo = assentosVeiculoService.findByColunas(coluna);
        if (assentosVeiculo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Assentos na coluna " + coluna + " não encontrados!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(assentosVeiculo);
    }

    @GetMapping("/{qtdAssentosColunas}")
    public ResponseEntity<Object> findByQtdAssentosColunas(@PathVariable(name = "qtdAssentosColunas") Integer qtdAssentosColunas) {
        List<AssentosVeiculo> assentosVeiculo = assentosVeiculoService.findByQtdAssentosColunas(qtdAssentosColunas);
        if (assentosVeiculo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Quantidade de assentos: " + qtdAssentosColunas + " não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(assentosVeiculo);
    }

}

