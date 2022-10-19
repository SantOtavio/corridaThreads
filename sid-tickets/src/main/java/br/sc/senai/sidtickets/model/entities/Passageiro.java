package br.sc.senai.sidtickets.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passageiro")
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Passageiro {
    @Id
    @Column(length = 11, nullable = false, unique = true)
    private Long cpf;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String sobrenome;

    @Column(length = 3, nullable = false)
    private Integer idade;

    public Passageiro() {

    }

}
