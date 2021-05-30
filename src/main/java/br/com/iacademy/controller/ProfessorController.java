package br.com.iacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Professor;
import br.com.iacademy.repository.ProfessorRepository;

@Controller
public class ProfessorController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastroProfessorTeste")
	public String inicio() {
		return "professor/cadastroProfessorTeste";
	}
		
	/*
	@RequestMapping(method = RequestMethod.GET, value="/cadastroProfessor")
	public ModelAndView iniciopos() {
		
		ModelAndView modelAndView = new ModelAndView("professor/cadastroProfessor");
		
		modelAndView.addObject("professorobj", new Professor());
 		
		return modelAndView;
	}	
	*/
	@RequestMapping(method = RequestMethod.POST, value="**/professorSave")
	public ModelAndView salvar(Professor professor) {
		
		professorRepository.save(professor);
		
		ModelAndView andView = new ModelAndView("professor/cadastroProfessor");
		
		//Iterable<Professor> professoresIt = professorRepository.findAll();
		
		//andView.addObject("professores", treinosIt);
		
		andView.addObject("professorobj", new Professor());
		
		return andView;
	}
		
	
	@RequestMapping(method = RequestMethod.GET, value="/professorAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("professor/cadastroProfessor");
		
		Iterable<Professor> professoresIt = professorRepository.findAll();
		
		andView.addObject("professores", professoresIt);
	
		andView.addObject("treinoobj", new Professor());
		
		return andView;
	}
	
	@GetMapping("/professorEdit/{id_professor}")
	public ModelAndView editar(@PathVariable("id_professor") Long id_professor) {
		
		Optional<Professor> professor = professorRepository.findById(id_professor);
		
		ModelAndView modelAndView = new ModelAndView("professor/cadastroProfessor");
		
		modelAndView.addObject("professorobj", professor.get());
		
		return modelAndView;
	}
}
