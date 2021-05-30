package br.com.iacademy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno{
	
	/*@JoinColumn(name = "pes_iden", referencedColumnName = "pes_iden", insertable = false, updatable = false)*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int alun_matricula;
	
	@NotNull
	private float peso;
	
	@NotNull
	private float altura;
	
	private String massaCorporal;
	
	@ManyToOne
    @JoinColumn(name = "pes_iden")
	private Pessoa pessoa;
	

	@OneToMany
    @JoinColumn(name = "alun_matricula") // Esta coluna está na tabela "Treino".
    private List<Treino> treino;
	
	public List<Treino> Treino() {
        return treino;
    }

	public int getAlun_matricula() {
		return alun_matricula;
	}

	public void setAlun_matricula(int alun_matricula) {
		this.alun_matricula = alun_matricula;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getMassaCorporal() {
		return massaCorporal;
	}

	public void setMassaCorporal(String massaCorporal) {
		this.massaCorporal = massaCorporal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + alun_matricula;
		result = prime * result + ((massaCorporal == null) ? 0 : massaCorporal.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Aluno other = (Aluno) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (alun_matricula != other.alun_matricula)
			return false;
		if (massaCorporal == null) {
			if (other.massaCorporal != null)
				return false;
		} else if (!massaCorporal.equals(other.massaCorporal))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	public Aluno() {
		super();
	}

	public Aluno(int alun_matricula, @NotNull float peso, @NotNull float altura, String massaCorporal, Pessoa pessoa) {
		super();
		this.alun_matricula = alun_matricula;
		this.peso = peso;
		this.altura = altura;
		this.massaCorporal = massaCorporal;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Aluno [alun_matricula=" + alun_matricula + ", peso=" + peso + ", altura=" + altura + ", massaCorporal="
				+ massaCorporal + ", pessoa=" + pessoa + "]";
	}
	
}