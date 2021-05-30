package br.com.iacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Treino;
import br.com.iacademy.repository.TreinoRepository;

@Controller
public class TreinoController {

	@Autowired
	TreinoRepository treinoRepository;
	
	/*
	@RequestMapping(method = RequestMethod.GET, value="/cadastroTreino")
	 
	public String inicio() {
		
		return "treino/cadastroTreino";
		
	}
	*/
	
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastroTreino")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("treino/cadastroTreino");
		
		modelAndView.addObject("treinoobj", new Treino());
		
		return modelAndView;
	}	

	@RequestMapping(method = RequestMethod.POST, value="**/treinoSave")
	public ModelAndView salvar(Treino treino) {
		
		treinoRepository.save(treino);
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
		
		return andView;
	
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST, value="** /treinoSave")
	public ModelAndView salvar(Treino treino) {
		
		treinoRepository.save(treino);
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
		
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	*/
		
	
	@RequestMapping(method = RequestMethod.GET, value="/treinoAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
	
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	
	
	@GetMapping("/treinoEdit/{id_treino}")
	public ModelAndView editar(@PathVariable("id_treino") Long id_treino) {
		
		Optional<Treino> treino = treinoRepository.findById(id_treino);
		
		ModelAndView modelAndView = new ModelAndView("treino/cadastro");
		
		modelAndView.addObject("treinoobj", treino.get());
		
		return modelAndView;
	}
	
}
