package br.com.brunoedubems.CadatroDeNinjas.Ninjas;

import br.com.brunoedubems.CadatroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table( name = "tb_cadastro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;
    //um ninja tem uma unica missao, Muitos ninjas terão uma ninja
    @ManyToOne
    @JoinColumn(name = "missoes_id") // criando a coluna da foreing key / chave estrangeira
    private MissoesModel missoes;
}
