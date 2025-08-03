package br.com.brunoedubems.CadatroDeNinjas.Missoes;

import br.com.brunoedubems.CadatroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String dificuldade;

    //Muito ninjas para uma missão
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas; // ou Set<NinjaModel>

}
