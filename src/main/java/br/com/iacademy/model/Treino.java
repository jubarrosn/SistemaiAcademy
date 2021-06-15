package br.com.iacademy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Treino  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long treino_iden;
	
	@NotNull//(message = "Informe a data Inicial.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")  
	private Date treino_data_inicial;
	
	@NotNull//(message = "Informe a data final.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date treino_vencimento;
	
	@NotNull//(message = "Informe o peso.")
	@Enumerated(EnumType.STRING)
    private AplicPeso aplicPeso;
	
	@NotNull//(message = "Informe a quantidade de repetições.")
	@Enumerated(EnumType.STRING)
    private AplicRepeticoes aplicRepeticoes;
	
	@NotNull//(message = "Informe a quantidade de séries.")
	@Enumerated(EnumType.STRING)
    private AplicSerie aplicSerie;
	
	@NotNull//(message = "Informe o exercício.")
	@Enumerated(EnumType.STRING)
	public Exercicios exercicios;
	
	@NotNull//(message = "Informe o esporte.")
	@Enumerated(EnumType.STRING)
	public Esportes esportes;
	
	//@Enumerated(EnumType.STRING)
	//public Turno turno;
	
	@NotNull//(message = "Informe o professor responsável.")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "prof_iden")
	private Professor professor;
	
	@NotNull//(message = "Informe o aluno.")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "alun_matricula")
	private Aluno aluno;

	
}