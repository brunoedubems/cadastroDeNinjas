package br.com.brunoedubems.CadatroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "boas vindas :) ";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());

    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas() {

        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


    // Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarTodosOsNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id : " + id + " não existe");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaDTO);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id : " + id + " não existe");
        }

    }


    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" O ninja com id " + id + " não encontrado");
        }
    }


}
