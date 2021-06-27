package br.com.iacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Treino;
import br.com.iacademy.repository.AlunoRepository;
import br.com.iacademy.repository.ProfessorRepository;
import br.com.iacademy.repository.TreinoRepository;

@Controller
@RequestMapping({"/treino"})
public class TreinoController {

	@Autowired
	TreinoRepository treinoRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	
	//SALVAR
	@PostMapping(value = "**/saveTreino")
	@ResponseBody
	public ResponseEntity<Treino> saveTreino (@RequestBody Treino treino) {
	
		treinoRepository.save(treino);
		
		return new ResponseEntity<Treino>(treino, HttpStatus.CREATED);
		
	}
	
	//DELETAR
	
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> deleteTreino(@RequestParam Long treino_iden){
		
		treinoRepository.deleteById(treino_iden);
		
		return new ResponseEntity<String>("Treino deletado com sucesso", HttpStatus.OK);
		
		
	}
	
	
	//ATULIZAR
	
	
	
	
	
	
	
	
	// BUSCAS
	@GetMapping(value= "/buscarTreino")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("buscarTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
	
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	
	@GetMapping(value = "listaTreino")
	@ResponseBody
	public ResponseEntity<List<Treino>> listaTreino() {
	
		List<Treino> treinos = treinoRepository.findAll();
		
		return new ResponseEntity<List<Treino>>(treinos, HttpStatus.OK);
	
	}
	
	/*@GetMapping(value = "buscaPrimeiroNome")
	@ResponseBody
	public ResponseEntity<List<Treino>> buscaPrimeiroNome (@RequestParam(name = "pes_prim_nome") String pes_prim_nome) {
		
		List<Treino> treino = treinoRepository.buscaPrimeiroNome(pes_prim_nome);
		
		
		return new ResponseEntity<List<Treino>>(treino, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "buscaMatricula")
	@ResponseBody
	public ResponseEntity<List<Treino>> buscaMatricula (@RequestParam(name = "alun_matricula") Integer alun_matricula) {
		
		List<Treino> treino = treinoRepository.buscaMatricula(alun_matricula);
		
		
		return new ResponseEntity<List<Treino>>(treino, HttpStatus.OK);
		
	}
	
	
	
	
	/*@PostMapping(value="/formAddTreino")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("/formAddTreino");

		modelAndView.addObject("treinoobj", new Treino());
		
		return modelAndView;
	}	
	 
	
	
	@SuppressWarnings("unused")
	@PostMapping(value="** /treinoSave")
	public ModelAndView salvar(Treino treino, Professor professor, Aluno aluno, Esportes esportes, Exercicios exercicios, AplicPeso aplicPeso, AplicRepeticoes aplicRepeticoes, AplicSerie aplicSerie, Turno turno, ModelAndView andView) {
		
		Treino treino1 = new Treino();
		
		
		Optional<Professor> oldProfessor = Optional.empty();
		Optional<Aluno> oldAluno = Optional.empty();
		Optional<Esportes> oldEsportes = Optional.empty();
		Optional<Exercicios> oldExercicios = Optional.empty();
		Optional<Turno> oldTurno = Optional.empty();
		Optional<AplicPeso> oldAplicPeso = Optional.empty();
		Optional<AplicRepeticoes> oldAplicRepeticoes = Optional.empty();
		Optional<AplicSerie> oldAplicSerie = Optional.empty();
		
        Object ModelAndView;
		if(oldAluno.isPresent()){
        	
        	String alunoTreino = oldAluno.get().getPessoa().getPes_prim_nome();
        	
        	if(oldProfessor.isPresent()){
        	
        		String professorTreino = oldProfessor.get().getFuncionario().getPessoa().getPes_prim_nome();
        		
        		if(oldEsportes.isPresent()){
        			
        			String esportesTreino = oldEsportes.get().getDescricao();
        			
        			if(oldExercicios.isPresent()){
        		
        				String exerciciosTreino = oldExercicios.get().getDescricao();
        				
        				if(oldAplicPeso.isPresent()){
        	        		
            				String aplicPesoTreino = oldAplicPeso.get().getDescricao();
            				
            				if(oldAplicRepeticoes.isPresent()){
            	        		
                				String aplicRepeticoesTreino = oldAplicRepeticoes.get().getDescricao();
                				
                				if(oldAplicSerie.isPresent()){
                	        		
                    				String aplicSerieTreino = oldAplicSerie.get().getDescricao();
                    				
                    				if(oldTurno.isPresent()){
                    	        		
                        				String turnoTreino = oldTurno.get().getDescricao();
                    				}
                    				
                				}
                				
            				}
            				
        				}
        				
        			}
        			
        		}
        		
        	}
        	
        
        treinoRepository.save(treino1);
        
        }else {
        	
        	ModelAndView andView1 = new ModelAndView("/errorProfessor");

		/////////////////////////////////////////////////////////////////////////////////// 
		/*treino.professor.setProfessor(newTreino.getProfessor(prof_iden));
		treino.esporte.setEsporte(newTreino.getEsporte(espt_iden));
    	treino.exercicio.setExercicio(newTreino.getExercicio(exerc_iden));
    	treino.aplicacaoExerc.setAplicacaoExerc(newTreino.getAplicacaoExerc(descricao));
    	treino.turno.setTurno(newTreino.getTurno(descricao));
    	treino.setTreino_data_inicial(newTreino.getTreino_data_inicial());
    	treino.setTreino_vencimento(newTreino.getTreino_vencimento());   	* /
		 ///////////////////////////////////////////////////////////////////////////////////
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView1.addObject("treinos", treinosIt);
        }
		return andView;
		
	} 
	
	@RequestMapping(method = RequestMethod.GET, value="/treinoAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
	
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	
	public ModelAndView buscasTreino(AlunoRepository aluno){
		
		ModelAndView modelAndView = new ModelAndView("BuscasTreinos");
		
		//Iterable<Treino> treinosIt = treinoRepository.findAll();
		
	//	andView.addObject("treinos", treinosIt);
	
	//	andView.addObject("treinoobj", new Treino());
		
	return modelAndView;
	}



	
	/*@Inject
	Turno turno;
	*/

	/*
	@RequestMapping(method = RequestMethod.GET, value="/cadastroTreino")
	public String inicio() {
		
		return "treino/cadastroTreino";
		
	}
	
	@GetMapping
	public List<Treino> findAll(){
	   return (List<Treino>) treinoRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long treino_iden){
	   return treinoRepository.findById(treino_iden)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/treinoSave", method =  RequestMethod.POST)
	public Treino create(@RequestBody Treino treino, long prof_iden, long alun_iden, long espt_iden, long exerc_iden, long aplic_iden){
		
		Treino newTreino = null;
		treino.setProfessor(newTreino.getProfessor(prof_iden));
     	treino.setAluno(newTreino.getAluno(alun_iden));
     	treino.setEsporte(newTreino.getEsporte(espt_iden));
     	treino.setExercicio(newTreino.getExercicio(exerc_iden));
     	treino.setAplicacaoExerc(newTreino.getAplicacaoExerc(aplic_iden));
     	
     	return treinoRepository.save(treino);
	}
	
	
    @SuppressWarnings({ "static-access" })
	@RequestMapping(value = "/treino/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Treino> Put(@PathVariable(value = "treino_iden") long id, @Valid @RequestBody Treino newTreino, long prof_iden, long alun_iden, long espt_iden, long exerc_iden, long aplic_iden){
    	
        Optional<Treino> oldTreino = treinoRepository.findById(id);
        if(oldTreino.isPresent()){
        	
        	Treino treino = oldTreino.get();
        	
        	treino.setProfessor(newTreino.getProfessor(prof_iden));
        	treino.setAluno(newTreino.getAluno(alun_iden));
        	treino.setEsporte(newTreino.getEsporte(espt_iden));
        	treino.setExercicio(newTreino.getExercicio(exerc_iden));
        	treino.setAplicacaoExerc(newTreino.getAplicacaoExerc(aplic_iden));
        	treino.setTreino_data_inicial(newTreino.getTreino_data_inicial());
        	treino.setTreino_vencimento(newTreino.getTreino_vencimento());   	
        	treinoRepository.save(treino);
        	 return new ResponseEntity<Treino>(treino, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 
        	//return new ResponseEntity(new Error("Erro ao atualizar", HttpStatus.NOT_FOUND);
        	//return new ResponseEntity<InfoMessages>( HttpStatus.NOT_FOUND);
        	//return new ResponseEntity<InfoMessages.CADASTRO_UPDATE_ERROR>(HttpStatus.NOT_FOUND);
    }   	
    
    
    @DeleteMapping
    public ResponseEntity <?> delete(@PathVariable long id) {
       return treinoRepository.findById(id)
               .map(record -> {
            	   treinoRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
	
	
    @RequestMapping(method =  RequestMethod.POST, value = "/treinoAluno/{treino_iden}")
    public void treinoAluno(){
    	
    		
       	 
        }
	
	
	
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastroTreino")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("treino/cadastroTreino");
		
		modelAndView.addObject("treinoobj", new Treino());
		
		return modelAndView;
	}	

	@RequestMapping(method = RequestMethod.POST, value="** /treinoSave")
	public ModelAndView salvar(Treino treino) {
		
		treinoRepository.save(treino);
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
		
		return andView;
	
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST, value="** /treinoSave")
	public ModelAndView salvar(Treino treino) {
		
		treinoRepository.save(treino);
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
		
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	*/
	/*	
	
	@RequestMapping(method = RequestMethod.GET, value="/treinoAll")
	public ModelAndView listar() {
		
		ModelAndView andView = new ModelAndView("treino/cadastroTreino");
		
		Iterable<Treino> treinosIt = treinoRepository.findAll();
		
		andView.addObject("treinos", treinosIt);
	
		andView.addObject("treinoobj", new Treino());
		
		return andView;
	}
	
	
	@GetMapping("/treinoEdit/{id_treino}")
	public ModelAndView editar(@PathVariable("id_treino") Long id_treino) {
		
		Optional<Treino> treino = treinoRepository.findById(id_treino);
		
		ModelAndView modelAndView = new ModelAndView("treino/cadastro");
		
		modelAndView.addObject("treinoobj", treino.get());
		
		return modelAndView;
	}
	*/
	
}
