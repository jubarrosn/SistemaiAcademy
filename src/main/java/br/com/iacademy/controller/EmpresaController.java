package br.com.iacademy.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Empresa;
import br.com.iacademy.repository.EmpresaRepository;

@Controller
@RequestMapping({"/**"})
@RestController
public class EmpresaController {

	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@PostMapping(value="/formAddEmpresa")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("/formAddEmpresa");

		modelAndView.addObject("empresaobj", new Empresa());
		
		return modelAndView;
	}	
	 
	
	
	@PostMapping(value="**/empresaSave")
	public ModelAndView salvar(Empresa empresa) {
		
		empresaRepository.save(empresa);
		
		ModelAndView andView = new ModelAndView("/formAddEmpresa");
		
		Iterable<Empresa> empresasIt = empresaRepository.findAll();
		
		andView.addObject("empresas", empresasIt);
		
		return andView;
		
	}
	
	@GetMapping("/empresaEdit/{empr_iden}")
	public ModelAndView editar(@PathVariable("empr_iden") Long empr_iden) {
		
		Optional<Empresa> empresa = empresaRepository.findById(empr_iden);
		
		ModelAndView modelAndView = new ModelAndView("/buscarEmpresa");
		
		modelAndView.addObject("empresaobj", empresa.get());
		
		return modelAndView;
	}
	
}
