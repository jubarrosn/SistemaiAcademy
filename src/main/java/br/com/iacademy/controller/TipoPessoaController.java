/*package br.com.iacademy.controller;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iacademy.model.TipoPessoa;

@Controller
@RequestMapping({"/tipoPessoa"})
public class TipoPessoaController {
	
	@Enumerated(EnumType.STRING)
	TipoPessoa tipoPessoa;
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastroPessoa")
	public String tipoPessoa(Object ALUNO, Object PROFESSOR) {
		
    if(tipoPessoa.equals(ALUNO)){
  	
    	return "/aluno/cadastroAluno";
  	
  	} else if (tipoPessoa.equals(PROFESSOR)){
  		
  		return "/professor/cadastroProfessor";
  		
  		}
	return null;
    }
	
}
*/