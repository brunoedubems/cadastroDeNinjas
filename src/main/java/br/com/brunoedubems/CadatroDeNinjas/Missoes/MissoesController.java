package br.com.brunoedubems.CadatroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões Listadas";
    }

    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missão criada";
    }

    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Missão alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }
}
