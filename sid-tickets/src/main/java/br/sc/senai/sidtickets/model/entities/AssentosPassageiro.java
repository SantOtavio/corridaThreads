package br.sc.senai.sidtickets.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "assento_passageiro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AssentosPassageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer assentosPassageiroId;

    @Column(length = 50, nullable = false)
    private Integer numColuna;

    @Column(length = 50, nullable = false)
    private Integer numAssento;

    @JoinColumn(name = "passageiro_cpf", referencedColumnName = "passageiro_cpf")
    @Column(nullable = false)
    private Passageiro passageiro;
}
