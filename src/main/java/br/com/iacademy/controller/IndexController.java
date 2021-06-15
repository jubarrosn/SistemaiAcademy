package br.com.iacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	

	
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String inicio() {
		return "login";
	}
	
	@RequestMapping("/saveTreino")
	public String saveTreino() {
		return "formAddTreino";
		}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping("/homeAdm")
	public String homeAdm() {
		return "homeAdm";
	}
	
	@RequestMapping("/homeProfessor")
	public String homeProfessor() {
		return "homeProfessor";
	}
	
	@RequestMapping("/homeAluno")
	public String homeAluno() {
		return "homeAluno";
	}
	
	@RequestMapping("/pagamentos")
	public String pagamentos() {
		return "pagamentos";
	}
	
	
	@RequestMapping("/formAddAlunoAdm")
	public String formAddAlunoAdm() {
		return "formAddAlunoAdm";
	}
	
	@RequestMapping("/formAddAlunoProf")
	public String formAddAlunoProf() {
		return "/formAddAlunoProf";
	}
	
	@RequestMapping("/formAddEmpresa")
	public String formAddEmpresa() {
		return "formAddEmpresa";
	}
	
	@RequestMapping("/empresas")
	public String empresa() {
		return "formAddEmpresa";
	}

	@RequestMapping("/formAddFuncionario")
	public String formAddFuncionario() {
		return "formAddFuncionario";
	}
	
	@RequestMapping("/formAddProfessor")
	public String formAddProfessor() {
		return "formAddProfessor";
	}
	
	@RequestMapping("/formAddTreino")
	public String formAddTreino() {
		return "formAddTreino";
	}
	
	@RequestMapping("/errorAdm")
	public String errorAdm() {
		return "errorAdm";
	}
	
	@RequestMapping("/errorProfessor")
	public String errorProfessor() {
		return "errorProfessor";
	}
	
	@RequestMapping("/errorAluno")
	public String errorAluno() {
		return "errorAluno";
	}
	
	@RequestMapping("**/error")
	public String erros() {
		return "erro";
	}
	
	@RequestMapping("/buscarAluno")
	public String buscarAluno() {
		return "buscarAluno";
	}
	
	@RequestMapping("/buscarTreino")
	public String buscarTreino() {
		return "buscarTreino";
	}
	
	/*@GetMapping("/medidas") //Não há medidas
	public String medidas() {
		return "medidas";
	}
	*/
	
}
