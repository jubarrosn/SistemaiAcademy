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
	
	/*
	@RequestMapping(method= RequestMethod.POST, value="** /empresaSave")
	  @ResponseStatus(HttpStatus.CREATED)
	  public Empresa insert( @RequestBody Empresa empresa) {
	      return empresa.save(empresa);
	  }
	

	@RequestMapping(method = RequestMethod.GET, value="** /empresas")
	public String empresa() {
		
		return "/formAddEmpresa";
		
	}
	*/
	
	
	/*@RequestMapping(method = RequestMethod.GET, value="** /empresaLista")
	public ModelAndView empresas() {
		
		ModelAndView andView = new ModelAndView("/formAddEmpresa");
		
		Iterable<Empresa> empresasIt = empresaRepository.findAll();
		
		andView.addObject("empresas", empresasIt);
		
		andView.addObject("empresaobj", new Empresa());
		
		return andView;
	}
	
	
	
	
	@GetMapping
	public List<Empresa> findAll(){
	   return (List<Empresa>) empresaRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long empr_iden){
	   return empresaRepository.findById(empr_iden)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
    @RequestMapping(value = "/empresa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Empresa> Put(@PathVariable(value = "empr_iden") long id, @Valid @RequestBody Empresa newEmpresa)
    {
        Optional<Empresa> oldEmpresa = empresaRepository.findById(id);
        if(oldEmpresa.isPresent()){
        	Empresa empresa = oldEmpresa.get();
        	empresa.setEmpr_cnpj(newEmpresa.getEmpr_cnpj());
        	empresa.setEmpr_contato(newEmpresa.getEmpr_contato());
        	empresa.setEmpr_razao_soc(newEmpresa.getEmpr_razao_soc()); 
        	empresa.setEmpr_nome_fant(newEmpresa.getEmpr_nome_fant()); 
        	empresa.setEmpr_endereco(newEmpresa.getEmpr_endereco());            
            empresaRepository.save(empresa);
            return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return empresaRepository.findById(id)
               .map(record -> {
            	   empresaRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }

	
	/* @RequestMapping(method = RequestMethod.GET, value="/cadastroEmpresa")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("empresa/cadastroEmpresa");

		modelAndView.addObject("empresaobj", new Empresa());
		
		return modelAndView;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value="** /empresaSave")
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
	
	/*
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