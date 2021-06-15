package br.com.iacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.iacademy.model.Aluno;
import br.com.iacademy.model.AplicPeso;
import br.com.iacademy.model.AplicRepeticoes;
import br.com.iacademy.model.AplicSerie;
import br.com.iacademy.model.Esportes;
import br.com.iacademy.model.Exercicios;
import br.com.iacademy.model.Professor;
import br.com.iacademy.model.Treino;
import br.com.iacademy.model.Turno;
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
	
	@PostMapping(value="/formAddTreino")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("/formAddTreino");

		modelAndView.addObject("treinoobj", new Treino());
		
		return modelAndView;
	}	
	 
	
	
	@SuppressWarnings("unused")
	@PostMapping(value="**/treinoSave")
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
    	treino.setTreino_vencimento(newTreino.getTreino_vencimento());   	*/
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
