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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(length = 100, nullable = false)
    private String local_partida;

    @Column(length = 100, nullable = false)
    private String local_chegada;

}
