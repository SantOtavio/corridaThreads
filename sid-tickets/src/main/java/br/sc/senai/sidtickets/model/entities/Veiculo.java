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

    @ManyToOne
    @JoinColumn(name = "assentos_veiculo_id", referencedColumnName = "assentos_veiculo_id", nullable = false)
    private AssentosVeiculo assentosVeiculo;

    @ManyToOne
    @JoinColumn(name = "assentos_passageiro_id", referencedColumnName = "assentos_passageiro_id", nullable = false)
    private AssentosPassageiro assentosPassageiro;

}
