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

import br.com.iacademy.model.Funcionario;
import br.com.iacademy.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	
		@Autowired
		private FuncionarioRepository funcionarioRepository;
		
		@GetMapping("/funcionarioAll")
		public List<Funcionario> listaFuncionario(){
			return  funcionarioRepository.findAll();
		}
			
		@GetMapping("/funcionarioId/{id}")
		public Optional<Funcionario> ListaFuncionarioId(@PathVariable(value = "id") long id) {
			return funcionarioRepository.findById(id);
		}
		
		@PostMapping("/funcionarioSave")
		public Funcionario salvaFuncionario(@RequestBody Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}
				
		@DeleteMapping("/funcionarioDelete")
		public void deleteFuncionario(@RequestBody Funcionario funcionario) {
			funcionarioRepository.delete(funcionario);
		}
		
		@PutMapping("/funcionarioUpdate")
		public Funcionario updateFuncionario(@RequestBody Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}
}