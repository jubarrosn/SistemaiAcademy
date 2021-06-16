package br.com.iacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Aluno;
import br.com.iacademy.model.Pessoa;
import br.com.iacademy.repository.AlunoRepository;
import br.com.iacademy.repository.PessoaRepository;

@Controller
@RequestMapping({"/pessoa"})
public class PessoaController {
	
	
	@Autowired
	PessoaRepository pessoaRepository;	
	
	@Autowired
	AlunoRepository alunoRepository;	
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("/");
		
		modelAndView.addObject("pessoaobj", new Pessoa());
		
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="**/pessoaSave")
	public ModelAndView salvar(Pessoa pessoa, Aluno aluno) {
		
		pessoaRepository.save(pessoa);
		alunoRepository.save(aluno);
		
		ModelAndView andView = new ModelAndView("/");
		
		//Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		
		//andView.addObject("pessoas", pessoasIt);
		
		andView.addObject("pessoaobj", new Aluno());	
		
		return andView;
	}


	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return pessoaRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
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
