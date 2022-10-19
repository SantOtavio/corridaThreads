package br.sc.senai.sidtickets.DTO;

import br.sc.senai.sidtickets.model.entities.AssentosVeiculo;
import br.sc.senai.sidtickets.model.entities.TipoVeiculo;
import lombok.Getter;

@Getter
public class VeiculoDTO {
    private TipoVeiculo tipoVeiculo;
    private String modeloVeiculo;
    private AssentosVeiculo assentosVeiculo;
}
