package br.com.iacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.iacademy.repository.AlunoRepository;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	/**
	@RequestMapping(method = RequestMethod.GET, value="/cadastroAluno")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("aluno/cadastroAluno");
		
		modelAndView.addObject("alunoobj", new Aluno());
		
		return modelAndView;
	}
	
			/*
			@RequestMapping(method = RequestMethod.POST, value="** /alunoSave")
			public String salvar(Aluno aluno) {
				
				alunoRepository.save(aluno);
				
				return "aluno/cadastroAluno";
			
			}
			*/
		
	/**
	@RequestMapping(method = RequestMethod.POST, value="** /alunoSave")
	public ModelAndView salvar(Aluno aluno) {
		
		alunoRepository.save(aluno);
		
		ModelAndView andView = new ModelAndView("aluno/cadastroAluno");
		
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		andView.addObject("alunos", alunosIt);
				
		return andView;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/alunoAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("aluno/alunosCadastrados");
		
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		andView.addObject("alunos", alunosIt);
	
		andView.addObject("alunoobj", new Aluno());
		
		return andView;
	}
	
	@GetMapping("/alunoEdit/{alun_matricula}")
	public ModelAndView editar(@PathVariable("alun_matricula") int alun_matricula) {
		
		Optional<Aluno> aluno = alunoRepository.findById(alun_matricula);
		
		ModelAndView modelAndView = new ModelAndView("aluno/alunosCadastrados");
		
		modelAndView.addObject("alunoobj", aluno.get());
		
		return modelAndView;
	}
*/
	/**	
			@GetMapping("/alunoAll")
			public List<Aluno> listaAluno(){
				return (List<Aluno>) alunoRepository.findAll();
			}
				
			@GetMapping("/alunoId/{alun_matricula}")
			public Optional<Aluno> listaAlunoId(@PathVariable(value = "alun_matricula") int alun_matricula) {
				return AlunoRepository.findById(alun_matricula);
			}
			
			@PostMapping("/alunoSave")
			public Aluno salvaAluno(@RequestBody Aluno aluno) {
				return alunoRepository.save(aluno);
			}
			
			@DeleteMapping("/alunoDelete")
			public void deleteAluno(@RequestBody Aluno aluno) {
				alunoRepository.delete(aluno);
			}
			
			@PutMapping("/alunoUpdate")
			public Aluno updateAluno(@RequestBody Aluno aluno) {
				return alunoRepository.save(aluno);
			}
			*/
}
