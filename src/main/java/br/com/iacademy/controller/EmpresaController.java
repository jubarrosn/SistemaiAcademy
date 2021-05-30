package br.com.iacademy.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Empresa;
import br.com.iacademy.repository.EmpresaRepository;

@Controller
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastroEmpresa")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("empresa/cadastroEmpresa");

		modelAndView.addObject("empresaobj", new Empresa());
		
		return modelAndView;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value="**/empresaSave")
	public ModelAndView salvar(Empresa empresa) {
		
		empresaRepository.save(empresa);
		
		ModelAndView andView = new ModelAndView("empresa/cadastroEmpresa");
		
		Iterable<Empresa> empresasIt = empresaRepository.findAll();
		
		andView.addObject("empresas", empresasIt);
		
		return andView;
		
	}
	
	/*
	@RequestMapping(method = RequestMethod.POST, value="** /empresaSave")
	public ModelAndView salvar(Empresa empresa) {
		
		empresaRepository.save(empresa);
		
		ModelAndView andView = new ModelAndView("empresa/cadastroEmpresa");
		
		Iterable<Empresa> empresasIt = empresaRepository.findAll();
		
		andView.addObject("empresas", empresasIt);
		
		andView.addObject("empresaobj", new Empresa());
		
		return andView;
	}
	*/
	
	
	@RequestMapping(method = RequestMethod.GET, value="/empresaAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("empresa/cadastroEmpresa");
		
		Iterable<Empresa> empresasIt = empresaRepository.findAll();
		
		andView.addObject("empresas", empresasIt);
		
		andView.addObject("empresaobj", new Empresa());
		
		return andView;
	}
	
	@GetMapping("/empresaEdit/{id_empresa}")
	public ModelAndView editar(@PathVariable("id_empresa") Long id_empresa) {
		
		Optional<Empresa> empresa = empresaRepository.findById(id_empresa);
		
		ModelAndView modelAndView = new ModelAndView("empresa/cadastroEmpresa");
		
		modelAndView.addObject("empresaobj", empresa.get());
		
		return modelAndView;
	}
	
	/**
	@GetMapping("/empresaAll")
	public List<Empresa> listaEmpresa(){
		return empresaRepository.findAll();
	}
		
	@GetMapping("/empresaId/{id}")
	public Empresa listaEmpresaId(@PathVariable(value = "id") long id) {
		return empresaRepository.findById(id);
	}
	
	@PostMapping("/empresaSave")
	public Empresa salvaEmpresa(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
		
	@DeleteMapping("/empresaDelete")
	public void deleteEmpresa(@RequestBody Empresa empresa) {
		empresaRepository.delete(empresa);
	}
	
	@PutMapping("/empresaUpdate")
	public Empresa updateEmpresa(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	**/
}