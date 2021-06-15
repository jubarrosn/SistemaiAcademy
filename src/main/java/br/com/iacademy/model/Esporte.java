/*package br.com.iacademy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Esporte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long espt_iden; 
	
	@NotNull
	private String espt_nome;
	
	private String espt_descricao;
	
	@OneToMany
    @JoinColumn(name = "espt_iden") // Esta coluna está na tabela "Treino".
    private List<Treino> treino;
	
	public List<Treino> Treino() {
        return treino;
    }

	public long getEspt_iden() {
		return espt_iden;
	}

	public void setEspt_iden(long espt_iden) {
		this.espt_iden = espt_iden;
	}

	public String getEspt_nome() {
		return espt_nome;
	}

	public void setEspt_nome(String espt_nome) {
		this.espt_nome = espt_nome;
	}

	public String getEspt_descricao() {
		return espt_descricao;
	}

	public void setEspt_descricao(String espt_descricao) {
		this.espt_descricao = espt_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((espt_descricao == null) ? 0 : espt_descricao.hashCode());
		result = prime * result + (int) (espt_iden ^ (espt_iden >>> 32));
		result = prime * result + ((espt_nome == null) ? 0 : espt_nome.hashCode());
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
		Esporte other = (Esporte) obj;
		if (espt_descricao == null) {
			if (other.espt_descricao != null)
				return false;
		} else if (!espt_descricao.equals(other.espt_descricao))
			return false;
		if (espt_iden != other.espt_iden)
			return false;
		if (espt_nome == null) {
			if (other.espt_nome != null)
				return false;
		} else if (!espt_nome.equals(other.espt_nome))
			return false;
		return true;
	}

	public Esporte() {
		super();
	}

	public Esporte(long espt_iden, @NotNull String espt_nome, String espt_descricao) {
		super();
		this.espt_iden = espt_iden;
		this.espt_nome = espt_nome;
		this.espt_descricao = espt_descricao;
	}

	@Override
	public String toString() {
		return "Esporte [espt_iden=" + espt_iden + ", espt_nome=" + espt_nome + ", espt_descricao=" + espt_descricao
				+ "]";
	}
		
}*/