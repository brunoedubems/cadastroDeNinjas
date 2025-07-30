package br.com.brunoedubems.CadatroDeNinjas.Missoes;

import br.com.brunoedubems.CadatroDeNinjas.NinjaModel;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;
    //Muito ninjas para uma missão
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

}
