package br.sc.senai.sidtickets.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assentos_veiculo")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode
public class AssentosVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idAssentosVeiculo;

    @Column(nullable = false)
    private List<Character> colunas;

    @Column(nullable = false)
    private String qtdAssentosColunas;

}
