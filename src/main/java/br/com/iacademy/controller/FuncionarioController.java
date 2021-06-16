package br.com.iacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Funcionario;
import br.com.iacademy.repository.FuncionarioRepository;

@Controller
@RequestMapping({"/funcionario"})
public class FuncionarioController {
	
	
		@Autowired
		FuncionarioRepository funcionarioRepository;
		
		@PostMapping(value="/formAddFuncionario")
		public ModelAndView inicio() {
			
			ModelAndView modelAndView = new ModelAndView("/formAddFuncionario");

			modelAndView.addObject("funcionarioobj", new Funcionario());
			
			return modelAndView;
		}	
		 
		
		
		@PostMapping(value="**/funcionarioSave")
		public ModelAndView salvar(Funcionario funcionario) {
			
			funcionarioRepository.save(funcionario);
			
			ModelAndView andView = new ModelAndView("/formAddFuncionario");
			
			Iterable<Funcionario> funcionariosIt = funcionarioRepository.findAll();
			
			andView.addObject("funcionarios", funcionariosIt);
			
			return andView;
			
		}
		
		@GetMapping("/funcionarioEdit/{empr_iden}")
		public ModelAndView editar(@PathVariable("empr_iden") Long func_iden) {
			
			Optional<Funcionario> funcionario = funcionarioRepository.findById(func_iden);
			
			ModelAndView modelAndView = new ModelAndView("/buscarFuncionario");
			
			modelAndView.addObject("funcionarioobj", funcionario.get());
			
			return modelAndView;
		}

}
	
