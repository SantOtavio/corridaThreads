package br.sc.senai.sidtickets.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoVeiculo {
    ONIBUS("Ônibus"),
    AVIAO("Avião"),
    TREM("Trem");
    String nome;
}
