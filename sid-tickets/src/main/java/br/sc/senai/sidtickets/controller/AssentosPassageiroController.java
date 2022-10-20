package br.sc.senai.sidtickets.controller;

import br.sc.senai.sidtickets.model.entities.AssentosPassageiro;
import br.sc.senai.sidtickets.model.entities.Veiculo;
import br.sc.senai.sidtickets.model.services.AssentosPassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sid/assentosPassageiro")
public class AssentosPassageiroController {

    @Autowired
    private AssentosPassageiroService assentosPassageiroService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (assentosPassageiroService.findAll().isEmpty()) {
            return ResponseEntity.status(404).body("Não foram encontrados assentos");
        } else {
            List<AssentosPassageiro> assentosPassageiros = assentosPassageiroService.findAll();
            return ResponseEntity.ok(assentosPassageiros);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if (assentosPassageiroService.findById(id).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado assento com o id " + id);
        } else {
            AssentosPassageiro assentosPassageiro = assentosPassageiroService.findById(id).get();
            return ResponseEntity.ok(assentosPassageiro);
        }
    }

}
