package br.com.iacademy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
/*
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="Exercicio")
@DiscriminatorValue("exerc_iden")*/
public class Exercicio{


	/*@JoinColumn(name = "exerc_iden", referencedColumnName = "exerc_iden", insertable = false, updatable = false)*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long exerc_iden; 
	
	@NotNull
	private String exerc_nome;
	
	@NotNull
	private String exerc_descrição;
	
	@OneToMany
    @JoinColumn(name = "exerc_iden") // Esta coluna está na tabela "Treino".
    private List<Treino> treino;
	
	public List<Treino> Treino() {
        return treino;
    }

	public long getExerc_iden() {
		return exerc_iden;
	}

	public void setExerc_iden(long exerc_iden) {
		this.exerc_iden = exerc_iden;
	}

	public String getExerc_nome() {
		return exerc_nome;
	}

	public void setExerc_nome(String exerc_nome) {
		this.exerc_nome = exerc_nome;
	}

	public String getExerc_descrição() {
		return exerc_descrição;
	}

	public void setExerc_descrição(String exerc_descrição) {
		this.exerc_descrição = exerc_descrição;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exerc_descrição == null) ? 0 : exerc_descrição.hashCode());
		result = prime * result + (int) (exerc_iden ^ (exerc_iden >>> 32));
		result = prime * result + ((exerc_nome == null) ? 0 : exerc_nome.hashCode());
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
		Exercicio other = (Exercicio) obj;
		if (exerc_descrição == null) {
			if (other.exerc_descrição != null)
				return false;
		} else if (!exerc_descrição.equals(other.exerc_descrição))
			return false;
		if (exerc_iden != other.exerc_iden)
			return false;
		if (exerc_nome == null) {
			if (other.exerc_nome != null)
				return false;
		} else if (!exerc_nome.equals(other.exerc_nome))
			return false;
		return true;
	}

	public Exercicio() {
		super();
	}

	public Exercicio(long exerc_iden, @NotNull String exerc_nome, @NotNull String exerc_descrição) {
		super();
		this.exerc_iden = exerc_iden;
		this.exerc_nome = exerc_nome;
		this.exerc_descrição = exerc_descrição;
	}

	@Override
	public String toString() {
		return "Exercicio [exerc_iden=" + exerc_iden + ", exerc_nome=" + exerc_nome + ", exerc_descrição="
				+ exerc_descrição + "]";
	}
	
}