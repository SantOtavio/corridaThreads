package br.sc.senai.sidtickets.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "veiculos_passagem")
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VeiculosPassagem {
    @Id
    @Column(length = 11, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(length = 11, nullable = false)
    private Passagem passagemId;

    @ManyToOne
    @Column(length = 11, nullable = false)
    private Veiculo veiculoId;

    @Column(length = 11, nullable = false)
    private Date dataPartida;

    @Column(length = 11, nullable = false)
    private Date dataChegada;

}
