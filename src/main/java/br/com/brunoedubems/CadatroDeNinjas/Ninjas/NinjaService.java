package br.com.brunoedubems.CadatroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Cria um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return  ninjaRepository.save(ninja);
    }


    // Deletar o ninja
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public  NinjaModel atualizaNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id); // pq não vai o id na requisição
            return ninjaRepository.save(ninjaAtualizado);
        }
        return  null;
    }
}
