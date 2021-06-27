package br.com.iacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Professor;
import br.com.iacademy.repository.FuncionarioRepository;
import br.com.iacademy.repository.ProfessorRepository;

@Controller
@RequestMapping({"/professor"})
public class ProfessorController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@PostMapping(value="/formAddProfessor")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("/formAddProfessor");

		modelAndView.addObject("professorobj", new Professor());
		
		return modelAndView;
	}	
	 
	
	
	@PostMapping(value="**/professorSave")
	public ModelAndView salvar(Professor professor) {
		
		professorRepository.save(professor);
		
		ModelAndView andView = new ModelAndView("/formAddProfessor");
		
		Iterable<Professor> professorsIt = professorRepository.findAll();
		
		andView.addObject("professors", professorsIt);
		
		return andView;
		
	}
	
	@GetMapping("/professorEdit/{func_iden}")
	public ModelAndView editar(@PathVariable("func_iden") Long func_iden) {
		
		Optional<Professor> professor = professorRepository.findById(func_iden);
		
		ModelAndView modelAndView = new ModelAndView("/formAddProfessor");
		
		modelAndView.addObject("professorobj", professor.get());
		
		return modelAndView;
	}
	
	
	
	
	
	
	/*
	@GetMapping
	public List<Professor> findAll(){
	   return (List<Professor>) professorRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long prof_iden){
	   return professorRepository.findById(prof_iden)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Professor create(@RequestBody Professor professor){
	   	professorRepository.save(professor);
	   	funcionarioRepository.save(professor.funcionario);
	   	pessoaRepository.save(professor.funcionario.pessoa);
	   	return null;
	}
	
	
    @RequestMapping(value = "/professor/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Professor> Put(@PathVariable(value = "prof_iden") long id, @Valid @RequestBody Professor newProfessor)
    {
        Optional<Professor> oldProfessor = professorRepository.findById(id);
        if(oldProfessor.isPresent()){
        	Professor professor = oldProfessor.get();
        	professor.funcionario.pessoa.setPes_prim_nome(newProfessor.getFuncionario().getPessoa().getPes_prim_nome());
        	professor.funcionario.pessoa.setPes_sobrenome(newProfessor.getFuncionario().getPessoa().getPes_sobrenome());
        	professor.funcionario.pessoa.setPes_endereco(newProfessor.getFuncionario().getPessoa().getPes_endereco());
        	professor.funcionario.pessoa.setPes_cpf(newProfessor.getFuncionario().getPessoa().getPes_cpf());
        	professor.funcionario.pessoa.setPes_rg(newProfessor.getFuncionario().getPessoa().getPes_rg());
        	professor.funcionario.pessoa.setPes_telefone(newProfessor.getFuncionario().getPessoa().getPes_telefone());
        	professor.funcionario.pessoa.setPes_rg_emissao(newProfessor.getFuncionario().getPessoa().getPes_rg_emissao());
        	professor.funcionario.pessoa.setPes_data_nasc(newProfessor.getFuncionario().getPessoa().getPes_data_nasc());
        	professor.funcionario.pessoa.setSexo(newProfessor.getFuncionario().getPessoa().getSexo());
        	professor.funcionario.pessoa.setPes_naturalidade(newProfessor.getFuncionario().getPessoa().getPes_naturalidade());
        	professor.funcionario.pessoa.setPes_nacionalidade(newProfessor.getFuncionario().getPessoa().getPes_nacionalidade());
        	professor.funcionario.pessoa.setPes_orient_medic(newProfessor.getFuncionario().getPessoa().getPes_orient_medic());
        	professor.funcionario.setEstadoCivil(newProfessor.getFuncionario().getEstadoCivil());
        	professor.funcionario.setFunc_cpts(newProfessor.getFuncionario().getFunc_cpts());
        	professor.funcionario.setFunc_serie_cpts(newProfessor.getFuncionario().getFunc_cpts());
        	professor.funcionario.setFunc_pis(newProfessor.getFuncionario().getFunc_pis());
        	professor.funcionario.setFunc_cnh(newProfessor.getFuncionario().getFunc_cnh());
        	professor.funcionario.setFunc_cnh_categ(newProfessor.getFuncionario().getFunc_cnh_categ());
        	professor.funcionario.setFunc_cnh_validade(newProfessor.getFuncionario().getFunc_cnh_validade());
        	professor.funcionario.setFunc_escolaridade(newProfessor.getFuncionario().getFunc_escolaridade());
        	professor.funcionario.setFunc_nome_conjuge(newProfessor.getFuncionario().getFunc_nome_conjuge());
        	professor.funcionario.setFunc_nome_mae(newProfessor.getFuncionario().getFunc_nome_mae());
        	professor.funcionario.setFunc_nome_pai(newProfessor.getFuncionario().getFunc_nome_pai());
        	professor.funcionario.setFunc_admissao(newProfessor.getFuncionario().getFunc_admissao());
        	professor.funcionario.setFunc_demissao(newProfessor.getFuncionario().getFunc_demissao());
        	professor.setProf_confef(newProfessor.getProf_confef());
        	professorRepository.save(professor);
        	funcionarioRepository.save(professor.funcionario);
        	pessoaRepository.save(professor.funcionario.pessoa);
            return new ResponseEntity<Professor>(professor, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping
    public ResponseEntity <?> delete(@PathVariable long id) {
       return professorRepository.findById(id)
               .map(record -> {
            	   professorRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
	
	
	
	
	/*
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
	*//*
	@RequestMapping(method = RequestMethod.POST, value="** /professorSave")
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
	}*/
}
