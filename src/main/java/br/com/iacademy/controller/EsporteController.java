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

import br.com.iacademy.model.Esporte;
import br.com.iacademy.repository.EsporteRepository;

@Controller

@RequestMapping({"/esporte"})
public class EsporteController {
	
	
		@Autowired
		private EsporteRepository esporteRepository;
		
		@GetMapping
		public List<Esporte> findAll(){
		   return (List<Esporte>) esporteRepository.findAll();
		}
		
		
		@GetMapping(path = {"/{id}"})
		public ResponseEntity<?> findById(@PathVariable long espt_iden){
		   return esporteRepository.findById(espt_iden)
		           .map(record -> ResponseEntity.ok().body(null))
		           .orElse(ResponseEntity.notFound().build());
		}
		
		
		@PostMapping
		public Esporte create(@RequestBody Esporte esporte){
		   return esporteRepository.save(esporte);
		}
		
		
	    @RequestMapping(value = "/esporte/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Esporte> Put(@PathVariable(value = "espt_iden") long id, @Valid @RequestBody Esporte newEsporte)
	    {
	        Optional<Esporte> oldEsporte = esporteRepository.findById(id);
	        if(oldEsporte.isPresent()){
	        	Esporte esporte = oldEsporte.get();
	        	esporte.setEspt_nome(newEsporte.getEspt_nome());
	        	esporte.setEspt_descricao(newEsporte.getEspt_descricao());     
	        	esporteRepository.save(esporte);
	            return new ResponseEntity<Esporte>(esporte, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    
	    @DeleteMapping(path ={"/{id}"})
	    public ResponseEntity <?> delete(@PathVariable long id) {
	       return esporteRepository.findById(id)
	               .map(record -> {
	            	   esporteRepository.deleteById(id);
	                   return ResponseEntity.ok().build();
	               }).orElse(ResponseEntity.notFound().build());
	    }
		
		
		
		/*@GetMapping("/esporteAll")
		public List<Esporte> listaEsporte(){
			return esporteRepository.findAll();
		}
			
		@GetMapping("/esporteId/{id}")
		public Optional<Esporte> listaEsporteId(@PathVariable(value = "id") long id) {
			return esporteRepository.findById(id);
		}
		
		@PostMapping("/esporteSave")
		public Esporte salvaEsporte(@RequestBody Esporte esporte) {
			return esporteRepository.save(esporte);
		}	
		
		@DeleteMapping("/esporteDelete")
		public void deleteEsporte(@RequestBody Esporte esporte) {
			esporteRepository.delete(esporte);
		}
		
		@PutMapping("/esporteUpdate")
		public Esporte updateEsporte(@RequestBody Esporte esporte) {
			return esporteRepository.save(esporte);
		}* /
}*/