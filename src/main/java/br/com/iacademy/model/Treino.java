package br.com.iacademy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Treino{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long treino_iden;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")  
	private Date treino_data_inicial;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date treino_vencimento;
	
	@ManyToOne
    @JoinColumn(name = "aplic_iden")
	private AplicacaoExerc aplicacaoExerc;
	
	@ManyToOne
    @JoinColumn(name = "exerc_iden")
	private Exercicio exercicio;
	
	@ManyToOne
    @JoinColumn(name = "espt_iden")
	private Esporte esporte;
	
	@ManyToOne
    @JoinColumn(name = "prof_iden")
	private Professor professor;
	
	@ManyToOne
    @JoinColumn(name = "alun_iden")
	private Aluno aluno;
	
	@Enumerated(EnumType.STRING)
	private Turno turno;

	public long getTreino_iden() {
		return treino_iden;
	}

	public void setTreino_iden(long treino_iden) {
		this.treino_iden = treino_iden;
	}

	public Date getTreino_data_inicial() {
		return treino_data_inicial;
	}

	public void setTreino_data_inicial(Date treino_data_inicial) {
		this.treino_data_inicial = treino_data_inicial;
	}

	public Date getTreino_vencimento() {
		return treino_vencimento;
	}

	public void setTreino_vencimento(Date treino_vencimento) {
		this.treino_vencimento = treino_vencimento;
	}

	public AplicacaoExerc getAplicacaoExerc() {
		return aplicacaoExerc;
	}

	public void setAplicacaoExerc(AplicacaoExerc aplicacaoExerc) {
		this.aplicacaoExerc = aplicacaoExerc;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((aplicacaoExerc == null) ? 0 : aplicacaoExerc.hashCode());
		result = prime * result + ((esporte == null) ? 0 : esporte.hashCode());
		result = prime * result + ((exercicio == null) ? 0 : exercicio.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((treino_data_inicial == null) ? 0 : treino_data_inicial.hashCode());
		result = prime * result + (int) (treino_iden ^ (treino_iden >>> 32));
		result = prime * result + ((treino_vencimento == null) ? 0 : treino_vencimento.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treino other = (Treino) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (aplicacaoExerc == null) {
			if (other.aplicacaoExerc != null)
				return false;
		} else if (!aplicacaoExerc.equals(other.aplicacaoExerc))
			return false;
		if (esporte == null) {
			if (other.esporte != null)
				return false;
		} else if (!esporte.equals(other.esporte))
			return false;
		if (exercicio == null) {
			if (other.exercicio != null)
				return false;
		} else if (!exercicio.equals(other.exercicio))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (treino_data_inicial == null) {
			if (other.treino_data_inicial != null)
				return false;
		} else if (!treino_data_inicial.equals(other.treino_data_inicial))
			return false;
		if (treino_iden != other.treino_iden)
			return false;
		if (treino_vencimento == null) {
			if (other.treino_vencimento != null)
				return false;
		} else if (!treino_vencimento.equals(other.treino_vencimento))
			return false;
		if (turno != other.turno)
			return false;
		return true;
	}

	public Treino() {
		super();
	}

	public Treino(long treino_iden, @NotNull Date treino_data_inicial, @NotNull Date treino_vencimento,
			AplicacaoExerc aplicacaoExerc, Exercicio exercicio, Esporte esporte, Professor professor, Aluno aluno,
			Turno turno) {
		super();
		this.treino_iden = treino_iden;
		this.treino_data_inicial = treino_data_inicial;
		this.treino_vencimento = treino_vencimento;
		this.aplicacaoExerc = aplicacaoExerc;
		this.exercicio = exercicio;
		this.esporte = esporte;
		this.professor = professor;
		this.aluno = aluno;
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Treino [treino_iden=" + treino_iden + ", treino_data_inicial=" + treino_data_inicial
				+ ", treino_vencimento=" + treino_vencimento + ", aplicacaoExerc=" + aplicacaoExerc + ", exercicio="
				+ exercicio + ", esporte=" + esporte + ", professor=" + professor + ", aluno=" + aluno + ", turno="
				+ turno + "]";
	}
	
}