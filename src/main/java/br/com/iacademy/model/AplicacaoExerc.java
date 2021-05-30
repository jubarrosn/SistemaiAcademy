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
@Table(name="AplicacaoExerc")
@PrimaryKeyJoinColumn(referencedColumnName = "exerc_iden")
@DiscriminatorValue("exerc_iden")*/
public class AplicacaoExerc{

	/*
	public AplicacaoExerc(long exerc_iden, String exerc_nome, String exerc_descrição) {
		super(exerc_iden, exerc_nome, exerc_descrição);
		// TODO Auto-generated constructor stub
	}
	@JoinColumn(name = "exerc_iden")
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aplic_iden;
	
	@NotNull
	private String aplic_duracao;
	
	@NotNull
	private String aplic_intensidade;
	
	@NotNull
	private int aplic_repeticoes;
	
	@OneToMany
    @JoinColumn(name = "aplic_iden") // Esta coluna está na tabela "Treino".
    private List<Treino> treino;
	
	public List<Treino> Treino() {
        return treino;
    }

	public long getAplic_iden() {
		return aplic_iden;
	}

	public void setAplic_iden(long aplic_iden) {
		this.aplic_iden = aplic_iden;
	}

	public String getAplic_duracao() {
		return aplic_duracao;
	}

	public void setAplic_duracao(String aplic_duracao) {
		this.aplic_duracao = aplic_duracao;
	}

	public String getAplic_intensidade() {
		return aplic_intensidade;
	}

	public void setAplic_intensidade(String aplic_intensidade) {
		this.aplic_intensidade = aplic_intensidade;
	}

	public int getAplic_repeticoes() {
		return aplic_repeticoes;
	}

	public void setAplic_repeticoes(int aplic_repeticoes) {
		this.aplic_repeticoes = aplic_repeticoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aplic_duracao == null) ? 0 : aplic_duracao.hashCode());
		result = prime * result + (int) (aplic_iden ^ (aplic_iden >>> 32));
		result = prime * result + ((aplic_intensidade == null) ? 0 : aplic_intensidade.hashCode());
		result = prime * result + aplic_repeticoes;
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
		AplicacaoExerc other = (AplicacaoExerc) obj;
		if (aplic_duracao == null) {
			if (other.aplic_duracao != null)
				return false;
		} else if (!aplic_duracao.equals(other.aplic_duracao))
			return false;
		if (aplic_iden != other.aplic_iden)
			return false;
		if (aplic_intensidade == null) {
			if (other.aplic_intensidade != null)
				return false;
		} else if (!aplic_intensidade.equals(other.aplic_intensidade))
			return false;
		if (aplic_repeticoes != other.aplic_repeticoes)
			return false;
		return true;
	}

	public AplicacaoExerc() {
		super();
	}

	public AplicacaoExerc(long aplic_iden, String aplic_duracao, String aplic_intensidade, int aplic_repeticoes) {
		super();
		this.aplic_iden = aplic_iden;
		this.aplic_duracao = aplic_duracao;
		this.aplic_intensidade = aplic_intensidade;
		this.aplic_repeticoes = aplic_repeticoes;
	}

	@Override
	public String toString() {
		return "AplicacaoExerc [aplic_iden=" + aplic_iden + ", aplic_duracao=" + aplic_duracao + ", aplic_intensidade="
				+ aplic_intensidade + ", aplic_repeticoes=" + aplic_repeticoes + "]";
	}
	
}