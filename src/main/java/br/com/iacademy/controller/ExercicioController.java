package br.com.iacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Exercicio;
import br.com.iacademy.repository.ExercicioRepository;

@Controller
public class ExercicioController {
	
	@Autowired
	ExercicioRepository exercicioRepository;
	
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

}