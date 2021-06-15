/*package br.com.iacademy.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iacademy.model.AplicacaoExerc;
import br.com.iacademy.repository.AplicacaoExercRepository;

@Controller
@RequestMapping({"/aplicacaoExerc"})
public class AplicacaoExercController {
	
	@Autowired
	AplicacaoExercRepository aplicacaoExercRepository;
	
	
	@GetMapping
	public List<AplicacaoExerc> findAll(){
	   return (List<AplicacaoExerc>) aplicacaoExercRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long aplic_iden){
	   return aplicacaoExercRepository.findById(aplic_iden)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public AplicacaoExerc create(@RequestBody AplicacaoExerc aplicacaoExerc){
	   return aplicacaoExercRepository.save(aplicacaoExerc);
	}
	
	
    @RequestMapping(value = "/treino/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<AplicacaoExerc> Put(@PathVariable(value = "aplic_iden") long id, @Valid @RequestBody AplicacaoExerc newAplicacaoExerc)
    {
        Optional<AplicacaoExerc> oldAplicacaoExerc = aplicacaoExercRepository.findById(id);
        if(oldAplicacaoExerc.isPresent()){
        	AplicacaoExerc aplicacaoExerc = oldAplicacaoExerc.get();
            aplicacaoExerc.setAplic_duracao(newAplicacaoExerc.getAplic_duracao());
            aplicacaoExerc.setAplic_intensidade(newAplicacaoExerc.getAplic_intensidade());
            aplicacaoExerc.setAplic_repeticoes(newAplicacaoExerc.getAplic_repeticoes());            
            aplicacaoExercRepository.save(aplicacaoExerc);
            return new ResponseEntity<AplicacaoExerc>(aplicacaoExerc, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return aplicacaoExercRepository.findById(id)
               .map(record -> {
            	   aplicacaoExercRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }

}*/