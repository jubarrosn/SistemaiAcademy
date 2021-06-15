package br.com.iacademy.controller;

import java.util.Arrays;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Aluno;
import br.com.iacademy.model.Pessoa;
import br.com.iacademy.model.SexoPessoa;
import br.com.iacademy.repository.AlunoRepository;
import br.com.iacademy.repository.PessoaRepository;

@Controller
@RequestMapping({"/aluno"})
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/formAddAlunoAdm")
	public ModelAndView inicio(Aluno aluno) {
		
		ModelAndView modelAndView = new ModelAndView("/formAddAlunoAdm");
		modelAndView.addObject("sexos", Arrays.asList(SexoPessoa.values()));
		modelAndView.addObject("alunoobj", new Aluno());
		
		return modelAndView;
	}
	
	//FUNÇÃO PARA CHAMAR ALUNO SEPARADO DE PROFESSOR, CADA FUNÇÃO CHAMADA FAZ A PERSISTÊNCIA
	@RequestMapping(method = RequestMethod.POST, value="**/alunoSave")
	public ModelAndView salvar(EntityManager entityManager) {
		
		Aluno aluno = new Aluno();
		Pessoa pessoa = new Pessoa();
		
		
		alunoRepository.save(aluno);
		pessoaRepository.save(pessoa);
		
		ModelAndView andView = new ModelAndView("/formAddAlunoAdm");
		
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		andView.addObject("alunos", alunosIt);
		
		andView.addObject("alunoobj", new Aluno());	
		
		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pessoaAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("/formAddAlunoAdm");
		
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		andView.addObject("alunos", alunosIt);
		
		andView.addObject("alunoobj", new Aluno());		
		
		return andView;
	}

	
	@RequestMapping(method = RequestMethod.GET, value="/alunoEdit/{alun_iden}")
	public ModelAndView editar(@PathVariable("alun_iden") Integer alun_iden) {
		
		java.util.Optional<Aluno> aluno = alunoRepository.findById(alun_iden);
		
		ModelAndView modelAndView = new ModelAndView("/buscarAluno");
		
		modelAndView.addObject("alunoobj", aluno.get());
		
		return modelAndView;
	}
	
/*	public String calculoImc(Object peso, Object altura){

    	String massaCorporal; 
    	float objpeso = (float) peso;
    	float objaltura = (float) altura;
    	float imc = ((objpeso)/(objaltura*objaltura)); 
			
	    	if (imc  < 18.5) {
	
	    			massaCorporal = "Abaixo do peso normal";
	    			return massaCorporal;
	    			
	    	}else if (imc >= 18.5 && imc <= 24.9) {
	    		
		    			massaCorporal = "Peso normal";
		    			return massaCorporal;
		    			
	    		}else if (imc >= 25 && imc <= 29.9) {
	    	
				    		massaCorporal = "Acima do peso normal";
	    					return massaCorporal;
		        			
    				} else if( imc > 30 && imc <= 39.9) {
    					
				    			massaCorporal = "Obsidade";
				    			return massaCorporal;
				    			
	    				}else {
	    					
	    					massaCorporal = "Obsidade Mórbida";
			    			return massaCorporal;
			    			
	    				}
    }
	*/
	/*
	@RequestMapping(method = RequestMethod.GET, value="/alunoAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("/buscarAluno");
		
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		andView.addObject("alunos", alunosIt);
		
		andView.addObject("alunoobj", new Aluno());		
		
		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/alunoEdit/{id_aluno}")
	public ModelAndView update(@PathVariable("alun_iden") Long alun_iden) {
		
		//Optional<Aluno> aluno = alunoRepository.findById(alun_iden);
		
		ModelAndView modelAndView = new ModelAndView("/buscarAluno");
		
		//modelAndView.addObject("alunoobj", aluno.get());
		
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/alunoDelete/{alun_iden}")
	public ModelAndView delete(@PathVariable("alun_iden") Long alun_iden) {
		
		pessoaRepository.deleteById(alun_iden);
		
		ModelAndView modelAndView = new ModelAndView("/buscarAluno");
		
		modelAndView.addObject("alunos", alunoRepository.findAll());

		modelAndView.addObject("alunoobj", new Aluno());
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="** /buscarAluno")
			public ResponseEntity<Aluno> Put(@PathVariable(value = "alun_matricula") int alun_matricula, @Valid @RequestBody Aluno newAluno)
	    {
	        Optional<Aluno> oldAluno = alunoRepository.findById(alun_matricula);
	        ResponseEntity<Aluno> modelAndView = null;
			if(oldAluno.isPresent()){
        	Aluno aluno = oldAluno.get();
        	aluno.pessoa.setPes_prim_nome(newAluno.getPessoa().getPes_prim_nome());
        	aluno.pessoa.setPes_sobrenome(newAluno.getPessoa().getPes_sobrenome());
        	aluno.pessoa.setPes_endereco(newAluno.getPessoa().getPes_endereco());
        	aluno.pessoa.setPes_cpf(newAluno.getPessoa().getPes_cpf());
        	aluno.pessoa.setPes_rg(newAluno.getPessoa().getPes_rg());
        	aluno.pessoa.setPes_telefone(newAluno.getPessoa().getPes_telefone());
        	aluno.pessoa.setPes_rg_emissao(newAluno.getPessoa().getPes_rg_emissao());
        	aluno.pessoa.setPes_data_nasc(newAluno.getPessoa().getPes_data_nasc());
        	aluno.pessoa.setSexo(newAluno.getPessoa().getSexo());
        	aluno.pessoa.setPes_naturalidade(newAluno.getPessoa().getPes_naturalidade());
            aluno.pessoa.setPes_nacionalidade(newAluno.getPessoa().getPes_nacionalidade());
            aluno.pessoa.setPes_orient_medic(newAluno.getPessoa().getPes_orient_medic());
        	aluno.setPeso(newAluno.getPeso());
        	aluno.setAltura(newAluno.getAltura());
        	this.CalculoImc(aluno.getPeso() , aluno.getAltura());
        	aluno.setMassaCorporal(newAluno.getMassaCorporal()); 
        	alunoRepository.save(aluno);
        	pessoaRepository.save(aluno.pessoa);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        }
        else
            
		return modelAndView;
	}
	
	public String CalculoImc(Object peso, Object altura){

    	String massaCorporal; 
    	float objpeso = (float) peso;
    	float objaltura = (float) altura;
    	float imc = ((objpeso)/(objaltura*objaltura)); 
			
	    	if (imc  < 18.5) {
	
	    			massaCorporal = "Abaixo do peso normal";
	    			return massaCorporal;
	    			
	    	}else if (imc >= 18.5 && imc <= 24.9) {
	    		
		    			massaCorporal = "Peso normal";
		    			return massaCorporal;
		    			
	    		}else if (imc >= 25 && imc <= 29.9) {
	    	
				    		massaCorporal = "Acima do peso normal";
	    					return massaCorporal;
		        			
    				} else if( imc > 30 && imc <= 39.9) {
    					
				    			massaCorporal = "Obsidade";
				    			return massaCorporal;
				    			
	    				}else {
	    					
	    					massaCorporal = "Obsidade Mórbida";
			    			return massaCorporal;
			    			
	    				}
    }

	/*@GetMapping
	public List<Aluno> findAll(){
	   return (List<Aluno>) alunoRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable int alun_matricula){
	   return alunoRepository.findById(alun_matricula)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="** /alunoSave")
	public Aluno create(@RequestBody Aluno aluno){
	   alunoRepository.save(aluno);
	   pessoaRepository.save(aluno.pessoa);
	   return null;
	}
	
	
    @RequestMapping(value = "/aluno/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Aluno> Put(@PathVariable(value = "alun_matricula") int alun_matricula, @Valid @RequestBody Aluno newAluno)
    {
        Optional<Aluno> oldAluno = alunoRepository.findById(alun_matricula);
        if(oldAluno.isPresent()){
        	Aluno aluno = oldAluno.get();
        	aluno.pessoa.setPes_prim_nome(newAluno.getPessoa().getPes_prim_nome());
        	aluno.pessoa.setPes_sobrenome(newAluno.getPessoa().getPes_sobrenome());
        	aluno.pessoa.setPes_endereco(newAluno.getPessoa().getPes_endereco());
        	aluno.pessoa.setPes_cpf(newAluno.getPessoa().getPes_cpf());
        	aluno.pessoa.setPes_rg(newAluno.getPessoa().getPes_rg());
        	aluno.pessoa.setPes_telefone(newAluno.getPessoa().getPes_telefone());
        	aluno.pessoa.setPes_rg_emissao(newAluno.getPessoa().getPes_rg_emissao());
        	aluno.pessoa.setPes_data_nasc(newAluno.getPessoa().getPes_data_nasc());
        	aluno.pessoa.setSexo(newAluno.getPessoa().getSexo());
        	aluno.pessoa.setPes_naturalidade(newAluno.getPessoa().getPes_naturalidade());
            aluno.pessoa.setPes_nacionalidade(newAluno.getPessoa().getPes_nacionalidade());
            aluno.pessoa.setPes_orient_medic(newAluno.getPessoa().getPes_orient_medic());
        	aluno.setPeso(newAluno.getPeso());
        	aluno.setAltura(newAluno.getAltura());
        	this.CalculoImc(aluno.getPeso() , aluno.getAltura());
        	aluno.setMassaCorporal(newAluno.getMassaCorporal()); 
        	alunoRepository.save(aluno);
        	pessoaRepository.save(aluno.pessoa);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    public String CalculoImc(Object peso, Object altura){

    	String massaCorporal; 
    	float objpeso = (float) peso;
    	float objaltura = (float) altura;
    	float imc = ((objpeso)/(objaltura*objaltura)); 
			
	    	if (imc  < 18.5) {
	
	    			massaCorporal = "Abaixo do peso normal";
	    			return massaCorporal;
	    			
	    	}else if (imc >= 18.5 && imc <= 24.9) {
	    		
		    			massaCorporal = "Peso normal";
		    			return massaCorporal;
		    			
	    		}else if (imc >= 25 && imc <= 29.9) {
	    	
				    		massaCorporal = "Acima do peso normal";
	    					return massaCorporal;
		        			
    				} else if( imc > 30 && imc <= 39.9) {
    					
				    			massaCorporal = "Obsidade";
				    			return massaCorporal;
				    			
	    				}else {
	    					
	    					massaCorporal = "Obsidade Mórbida";
			    			return massaCorporal;
			    			
	    				}
    }
    
    @DeleteMapping
    public ResponseEntity <?> delete(@PathVariable int id) {
       return alunoRepository.findById(id)
               .map(record -> {
            	   alunoRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
	
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
