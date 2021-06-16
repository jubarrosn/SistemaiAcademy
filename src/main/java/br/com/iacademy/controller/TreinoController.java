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
		
		
	return modelAndView;
	}
	
}
