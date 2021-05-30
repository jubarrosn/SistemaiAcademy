package br.com.iacademy.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iacademy.model.Pessoa;
import br.com.iacademy.repository.PessoaRepository;

@Controller
@RequestMapping({"/pessoa"})
public class PessoaController {
	
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	
	@GetMapping
	public List<Pessoa> findAll(){
	   return (List<Pessoa>) pessoaRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return pessoaRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Pessoa create(@RequestBody Pessoa pessoa){
	   return pessoaRepository.save(pessoa);
	}
	
	
    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = pessoaRepository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setPes_prim_nome(newPessoa.getPes_prim_nome());
            pessoa.setPes_sobrenome(newPessoa.getPes_sobrenome());
            pessoa.setPes_endereco(newPessoa.getPes_endereco());
            pessoa.setPes_cpf(newPessoa.getPes_cpf());
            pessoa.setPes_rg(newPessoa.getPes_rg());
            pessoa.setPes_telefone(newPessoa.getPes_telefone());
            pessoa.setPes_rg_emissao(newPessoa.getPes_rg_emissao());
            pessoa.setPes_data_nasc(newPessoa.getPes_data_nasc());
            pessoa.setSexo(newPessoa.getSexo());
            pessoa.setPes_naturalidade(newPessoa.getPes_naturalidade());
            pessoa.setPes_nacionalidade(newPessoa.getPes_nacionalidade());
            pessoa.setPes_orient_medic(newPessoa.getPes_orient_medic());
            pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return pessoaRepository.findById(id)
               .map(record -> {
            	   pessoaRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
    
}   
    
    //--------------METODOS ANTERIORES ------------------------
    
    
    /*@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }
	*/
    /*@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	*/
    
    /*
    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
    {
        return pessoaRepository.save(pessoa);
    }
*/
	/*
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("recordID") long id,
	                                      @RequestBody Pessoa pessoa) {
	   return pessoaRepository.findById(id)
	           .map(record -> {
	               record.setName(contact.getName());
	               record.setEmail(contact.getEmail());
	               record.setPhone(contact.getPhone());
	               Contact updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	*/
    
    /*
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
*/
    
    
	/*
	@RequestMapping(method = RequestMethod.GET, value="/cadastroPessoa")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("pessoa/cadastroPessoa");
		
		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}*/
		/**------------------------
		@RequestMapping(method = RequestMethod.POST, value="** /pessoaSave")
		public String salvar(Pessoa pessoa) {
			
			pessoaRepository.save(pessoa);
			
			return "pessoa/cadastroPessoa";
		
		}
		-------------*/
	/*
	@RequestMapping(method = RequestMethod.POST, value="** /pessoaSave")
	public ModelAndView salvar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		
		ModelAndView andView = new ModelAndView("pessoa/cadastroPessoa");
		
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		
		andView.addObject("pessoas", pessoasIt);
		
		andView.addObject("pessoaobj", new Pessoa());	
		
		return andView;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/pessoaAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("pessoa/pessoaCadastradas");
		
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		
		andView.addObject("pessoas", pessoasIt);
		
		andView.addObject("pessoaobj", new Pessoa());		
		
		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pessoaEdit/{id_pessoa}")
	public ModelAndView update(@PathVariable("id_pessoa") Long pes_iden) {
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(pes_iden);
		
		ModelAndView modelAndView = new ModelAndView("pessoa/pessoaCadastradas");
		
		modelAndView.addObject("pessoaobj", pessoa.get());
		
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/pessoaDelete/{id_pessoa}")
	public ModelAndView delete(@PathVariable("id_pessoa") Long pes_iden) {
		
		pessoaRepository.deleteById(pes_iden);
		
		ModelAndView modelAndView = new ModelAndView("pessoa/pessoaCadastradas");
		
		modelAndView.addObject("pessoas", pessoaRepository.findAll());

		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="** /pesquisarPessoa")
	public ModelAndView pesquisar(@RequestParam("pesquisaNome") String pesquisaNome) {
		
		ModelAndView modelAndView = new ModelAndView("pessoa/cadastroPessoa");
		
		modelAndView.addObject("pessoas", pessoaRepository.findPessoaByName(pesquisaNome));
		
		modelAndView.addObject("pessaobj", new Pessoa());
		
		return modelAndView;
	}
	*/
	
			/* ------------------------------------------------------------------------
		    ---------------------------------------------------------------------------
		    ************FAZER A CONDIÇÃO PARA PUXAR CAMPOS DE OUTRAS CLASSES***********
		    ---------------------------------------------------------------------------
		    ------------------------------------------------------------------------ */
	/*
	@RequestMapping(method = RequestMethod.GET, value="/cadastroPessoa")
	public String tipoPessoa() {
		
    if(tipoPessoa.equals(ALUNO)){
  	
    	return "/aluno/cadastroAluno";
  	
  	} else if (tipoPessoa.equals(PROFESSOR)){
  		
  		return "/professor/cadastroProfessor";
  		
  		}
    
	return null;
  	
  	}
	
	*/
	
		/*
		//----------------------------------
		//Metodo Michelli Brito	
		//----------------------------------
		
		@RequestMapping(method = RequestMethod.GET, value= "/cadastroPessoaTeste")
		public String inicio() {
			return "/pessoa/cadastroPessoaTeste";
		}
		
		@GetMapping("/pessoaAll")
		public List<Pessoa> listaPessoa(){
			return (List<Pessoa>) pessoaRepository.findAll();
		}
			
		@GetMapping("/pessoaId/{id}")
		public Pessoa listaPessoaId(@PathVariable(value = "id") long id) {
			return pessoaRepository.findById(id);
		}	
		
		@PostMapping("/pessoaSave")
		public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
			return pessoaRepository.save(pessoa);
		}
	
		@DeleteMapping("/pessoaDelete")
		public void deletePessoa(@RequestBody Pessoa pessoa) {
			pessoaRepository.delete(pessoa);
		}
		
		@PutMapping("/pessoaUpdate")
		public Pessoa updatePessoa(@RequestBody Pessoa pessoa) {
			return pessoaRepository.save(pessoa);
		}
		*/