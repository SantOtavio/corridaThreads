package br.sc.senai.sidtickets.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "passagem")
public class Passagem {

    @Column(name = "passagem_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String origem;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String data_ida;

    @Column(nullable = false)
    private String data_volta;

    @Column(nullable = false)
    private Integer paradas;

    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;
}
