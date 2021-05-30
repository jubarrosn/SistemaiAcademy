package br.com.iacademy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.iacademy.model.Esporte;
import br.com.iacademy.repository.EsporteRepository;

@Controller
public class EsporteController {
	
	
		@Autowired
		private EsporteRepository esporteRepository;
		
		@GetMapping("/esporteAll")
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
		}
}