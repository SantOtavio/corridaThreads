package br.sc.senai.sidtickets.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "veiculos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode @ToString
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idVeiculo;

    @Column(length = 50, nullable = false)
    private String tipoVeiculo;

    @Column(length = 50, nullable = false)
    private String modeloVeiculo;

    @JoinColumn(name = "assentos_veiculo_id", referencedColumnName = "assentos_veiculo_id")
    @Column(nullable = false)
    private AssentosVeiculo assentosVeiculo;

    @JoinColumn(name = "assentos_passageiro_id", referencedColumnName = "assentos_passageiro_id")
    @Column(nullable = false)
    private AssentosPassageiro assentosPassageiro;

}
