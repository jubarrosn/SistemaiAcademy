package br.com.iacademy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Professor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prof_iden;
	
	@NotNull(message = "Informe o Registro CONFEF.")
	private String prof_confef; //CONFEF=Conselho Federal de Educação Física
	
	@OneToOne(cascade = {CascadeType.ALL}) // Esta coluna está na tabela "Funcionário".
    @JoinColumn(name = "func_iden")
    private Funcionario funcionario;
	
	@OneToMany(mappedBy = "professor", cascade = {CascadeType.ALL}) // Esta coluna está na tabela "Treino".
    private List<Treino> treino;
	
	public List<Treino> Treino() {
        return treino;
    }

	public long getProf_iden() {
		return prof_iden;
	}

	public void setProf_iden(long prof_iden) {
		this.prof_iden = prof_iden;
	}

	public String getProf_confef() {
		return prof_confef;
	}

	public void setProf_confef(String prof_confef) {
		this.prof_confef = prof_confef;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((prof_confef == null) ? 0 : prof_confef.hashCode());
		result = prime * result + (int) (prof_iden ^ (prof_iden >>> 32));
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
		Professor other = (Professor) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (prof_confef == null) {
			if (other.prof_confef != null)
				return false;
		} else if (!prof_confef.equals(other.prof_confef))
			return false;
		if (prof_iden != other.prof_iden)
			return false;
		return true;
	}

	public Professor() {
		super();
	}

	public Professor(long prof_iden, @NotNull String prof_confef, Funcionario funcionario) {
		super();
		this.prof_iden = prof_iden;
		this.prof_confef = prof_confef;
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Professor [prof_iden=" + prof_iden + ", prof_confef=" + prof_confef + ", funcionario=" + funcionario
				+ "]";
	}
	
	
}