package br.com.iacademy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cargo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long crg_iden;
	
	@NotNull
	private String crg_nome;
	
	@NotNull
	private String crg_funcao;
	
	@NotNull
	private float crg_salario;

	public long getCrg_iden() {
		return crg_iden;
	}

	public void setCrg_iden(long crg_iden) {
		this.crg_iden = crg_iden;
	}

	public String getCrg_nome() {
		return crg_nome;
	}

	public void setCrg_nome(String crg_nome) {
		this.crg_nome = crg_nome;
	}

	public String getCrg_funcao() {
		return crg_funcao;
	}

	public void setCrg_funcao(String crg_funcao) {
		this.crg_funcao = crg_funcao;
	}

	public float getCrg_salario() {
		return crg_salario;
	}

	public void setCrg_salario(float crg_salario) {
		this.crg_salario = crg_salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crg_funcao == null) ? 0 : crg_funcao.hashCode());
		result = prime * result + (int) (crg_iden ^ (crg_iden >>> 32));
		result = prime * result + ((crg_nome == null) ? 0 : crg_nome.hashCode());
		result = prime * result + Float.floatToIntBits(crg_salario);
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
		Cargo other = (Cargo) obj;
		if (crg_funcao == null) {
			if (other.crg_funcao != null)
				return false;
		} else if (!crg_funcao.equals(other.crg_funcao))
			return false;
		if (crg_iden != other.crg_iden)
			return false;
		if (crg_nome == null) {
			if (other.crg_nome != null)
				return false;
		} else if (!crg_nome.equals(other.crg_nome))
			return false;
		if (Float.floatToIntBits(crg_salario) != Float.floatToIntBits(other.crg_salario))
			return false;
		return true;
	}

	public Cargo() {
		super();
	}

	public Cargo(long crg_iden, @NotNull String crg_nome, @NotNull String crg_funcao, @NotNull float crg_salario) {
		super();
		this.crg_iden = crg_iden;
		this.crg_nome = crg_nome;
		this.crg_funcao = crg_funcao;
		this.crg_salario = crg_salario;
	}

	@Override
	public String toString() {
		return "Cargo [crg_iden=" + crg_iden + ", crg_nome=" + crg_nome + ", crg_funcao=" + crg_funcao
				+ ", crg_salario=" + crg_salario + "]";
	}

}