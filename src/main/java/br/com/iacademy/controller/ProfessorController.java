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
	

    @DeleteMapping
    public ResponseEntity <?> delete(@PathVariable long id) {
       return professorRepository.findById(id)
               .map(record -> {
            	   professorRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
	
}
