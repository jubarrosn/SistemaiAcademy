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
		/*
		  @GetMapping
		
		public List<Funcionario> findAll(){
		   return (List<Funcionario>) funcionarioRepository.findAll();
		}
		
		
		@GetMapping(path = {"/{id}"})
		public ResponseEntity<?> findById(@PathVariable int func_iden){
		   return funcionarioRepository.findById(func_iden)
		           .map(record -> ResponseEntity.ok().body(null))
		           .orElse(ResponseEntity.notFound().build());
		}
		
		
		@PostMapping
		public Funcionario create(@RequestBody Funcionario funcionario){
		    funcionarioRepository.save(funcionario);
		    pessoaRepository.save(funcionario.pessoa);
		    return null;
		}
		
		
	    @RequestMapping(value = "/funcionario/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Funcionario> Put(@PathVariable(value = "func_iden") int id, @Valid @RequestBody Funcionario newFuncionario)
	    {
	        Optional<Funcionario> oldFuncionario = funcionarioRepository.findById(id);
	        if(oldFuncionario.isPresent()){
	        	Funcionario funcionario = oldFuncionario.get();
	        	funcionario.pessoa.setPes_prim_nome(newFuncionario.getPessoa().getPes_prim_nome());
	        	funcionario.pessoa.setPes_sobrenome(newFuncionario.getPessoa().getPes_sobrenome());
	        	funcionario.pessoa.setPes_endereco(newFuncionario.getPessoa().getPes_endereco());
	        	funcionario.pessoa.setPes_cpf(newFuncionario.getPessoa().getPes_cpf());
	        	funcionario.pessoa.setPes_rg(newFuncionario.getPessoa().getPes_rg());
	        	funcionario.pessoa.setPes_telefone(newFuncionario.getPessoa().getPes_telefone());
	        	funcionario.pessoa.setPes_rg_emissao(newFuncionario.getPessoa().getPes_rg_emissao());
	        	funcionario.pessoa.setPes_data_nasc(newFuncionario.getPessoa().getPes_data_nasc());
	        	funcionario.pessoa.setSexo(newFuncionario.getPessoa().getSexo());
	        	funcionario.pessoa.setPes_naturalidade(newFuncionario.getPessoa().getPes_naturalidade());
	        	funcionario.pessoa.setPes_nacionalidade(newFuncionario.getPessoa().getPes_nacionalidade());
	        	funcionario.pessoa.setPes_orient_medic(newFuncionario.getPessoa().getPes_orient_medic());
	        	funcionario.setEstadoCivil(newFuncionario.getEstadoCivil());
	        	funcionario.setFunc_cpts(newFuncionario.getFunc_cpts());
	        	funcionario.setFunc_serie_cpts(newFuncionario.getFunc_cpts());
	        	funcionario.setFunc_pis(newFuncionario.getFunc_pis());
	        	funcionario.setFunc_cnh(newFuncionario.getFunc_cnh());
	        	funcionario.setFunc_cnh_categ(newFuncionario.getFunc_cnh_categ());
	        	funcionario.setFunc_cnh_validade(newFuncionario.getFunc_cnh_validade());
	        	funcionario.setFunc_escolaridade(newFuncionario.getFunc_escolaridade());
	        	funcionario.setFunc_nome_conjuge(newFuncionario.getFunc_nome_conjuge());
	        	funcionario.setFunc_nome_mae(newFuncionario.getFunc_nome_mae());
	        	funcionario.setFunc_nome_pai(newFuncionario.getFunc_nome_pai());
	        	funcionario.setFunc_admissao(newFuncionario.getFunc_admissao());
	        	funcionario.setFunc_demissao(newFuncionario.getFunc_demissao());
	        	funcionarioRepository.save(funcionario);
	        	pessoaRepository.save(funcionario.pessoa);
	            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @DeleteMapping
	    public ResponseEntity <?> delete(@PathVariable long id) {
	       return funcionarioRepository.findById(id)
	               .map(record -> {
	            	   funcionarioRepository.deleteById(id);
	                   return ResponseEntity.ok().build();
	               }).orElse(ResponseEntity.notFound().build());
	    }
		
		
		
		
/*		@GetMapping("/funcionarioAll")
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
	* /
}*/