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

import br.com.iacademy.model.Exercicio;
import br.com.iacademy.repository.ExercicioRepository;

@Controller
@RequestMapping({"/exercicio"})
public class ExercicioController {
	
	@Autowired
	ExercicioRepository exercicioRepository;

	@GetMapping
	public List<Exercicio> findAll(){
	   return (List<Exercicio>) exercicioRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long exerc_iden){
	   return exercicioRepository.findById(exerc_iden)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Exercicio create(@RequestBody Exercicio exercicio){
	   return exercicioRepository.save(exercicio);
	}
	
	
    @RequestMapping(value = "/treino/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Exercicio> Put(@PathVariable(value = "exerc_iden") long id, @Valid @RequestBody Exercicio newExercicio)
    {
        Optional<Exercicio> oldExercicio = exercicioRepository.findById(id);
        if(oldExercicio.isPresent()){
        	Exercicio exercicio = oldExercicio.get();
        	exercicio.setExerc_nome(newExercicio.getExerc_nome());
        	exercicio.setExerc_descricao(newExercicio.getExerc_descricao());
        	exercicioRepository.save(exercicio);
            return new ResponseEntity<Exercicio>(exercicio, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return exercicioRepository.findById(id)
               .map(record -> {
            	   exercicioRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
	
	
	
	/*	
	@RequestMapping(method = RequestMethod.GET, value= "/cadastroEexercicio")
	public String inicio() {
		return "exercicio/cadastroEexercicio";
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/exercicioSave")
	public ModelAndView salvar(Exercicio exercicio) {
		exercicioRepository.save(exercicio);
		
		ModelAndView andView = new ModelAndView("exercicio/cadastroExercicio");
		Iterable<Exercicio> exerciciosIt = exercicioRepository.findAll();
		andView.addObject("exercicios", exerciciosIt);
		return andView;
	}

	@RequestMapping(method = RequestMethod.GET, value="/exercicioAll")
	public ModelAndView exercicios() {
		ModelAndView andView = new ModelAndView("exercicio/cadastroExercicio");
		Iterable<Exercicio> exerciciosIt = exercicioRepository.findAll();
		andView.addObject("exercicios", exerciciosIt);
		return andView;
	}
*  /
}*/