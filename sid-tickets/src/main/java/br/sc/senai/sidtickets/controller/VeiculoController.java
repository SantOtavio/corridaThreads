package br.sc.senai.sidtickets.controller;

import br.sc.senai.sidtickets.DTO.VeiculoDTO;
import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.model.entities.TipoVeiculo;
import br.sc.senai.sidtickets.model.entities.Veiculo;
import br.sc.senai.sidtickets.model.services.VeiculoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sid/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (veiculoService.findAll().isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado veiculo");
        } else {
            List<Veiculo> veiculos = veiculoService.findAll();
            return ResponseEntity.ok(veiculos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if (veiculoService.findById(id).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado veiculo com o id " + id);
        } else {
            Veiculo veiculo = veiculoService.findById(id).get();
            return ResponseEntity.ok(veiculo);
        }
    }

    @GetMapping("/assento/{idAssento}")
    public ResponseEntity<Object> findByAssentosVeiculo(@PathVariable(value = "idAssento") AssentosVeiculo assentosVeiculo) {
        Optional<Veiculo> veiculos = veiculoService.findByAssentosVeiculo(assentosVeiculo);
        if (veiculos.isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado veiculo com o assento " + assentosVeiculo);
        } else {
            return ResponseEntity.ok(veiculos.get());
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Object> findByTipo(@PathVariable(value = "tipo") TipoVeiculo tipo) {
        List<Veiculo> veiculos = veiculoService.findByTipoVeiculo(tipo);
        if (veiculos.isEmpty()) {
            return ResponseEntity.status(404).body("Não foram encontrados veiculos com o tipo " + tipo);
        } else {
            return ResponseEntity.ok(veiculos);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid VeiculoDTO veiculoDTO) {
        if (veiculoDTO.getAssentosVeiculo() == null || veiculoDTO.getTipoVeiculo() == null) {
            return ResponseEntity.status(400).body("Não foi possível cadastrar o veiculo");
        } else if (veiculoService.findByAssentosVeiculo(veiculoDTO.getAssentosVeiculo()).isPresent()) {
            return ResponseEntity.status(400).body("Já existe um veiculo com esse assento");
        } else {
            Veiculo veiculo;
            BeanUtils.copyProperties(veiculoDTO, veiculo = new Veiculo());
            veiculoService.save(veiculo);
            return ResponseEntity.status(201).body("Veiculo cadastrado com sucesso");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid VeiculoDTO veiculoDTO) {
        if (veiculoService.findById(id).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado veiculo com o id " + id);
        } else if (veiculoDTO.getAssentosVeiculo() == null || veiculoDTO.getTipoVeiculo() == null) {
            return ResponseEntity.status(400).body("Não foi possível atualizar o veiculo pois os dados estão incompletos");
        } else {
            Veiculo veiculo;
            BeanUtils.copyProperties(veiculoDTO, veiculo = new Veiculo());
            veiculo.setIdVeiculo(id);
            veiculoService.save(veiculo);
            return ResponseEntity.status(200).body("Veiculo atualizado com sucesso");
        }
    }

}
