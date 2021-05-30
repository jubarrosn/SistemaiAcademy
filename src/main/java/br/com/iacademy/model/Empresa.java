package br.com.iacademy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empr_iden;
	
	@CNPJ
	@NotNull
	private int empr_cnpj;
	
	@NotNull
	private int empr_contato;
	
	@NotNull
	private String empr_razao_soc;
	
	@NotNull
	private String empr_nome_fant;
	
	private String empr_endereco;

	public long getEmpr_iden() {
		return empr_iden;
	}

	public void setEmpr_iden(long empr_iden) {
		this.empr_iden = empr_iden;
	}

	public int getEmpr_cnpj() {
		return empr_cnpj;
	}

	public void setEmpr_cnpj(int empr_cnpj) {
		this.empr_cnpj = empr_cnpj;
	}

	public int getEmpr_contato() {
		return empr_contato;
	}

	public void setEmpr_contato(int empr_contato) {
		this.empr_contato = empr_contato;
	}

	public String getEmpr_razao_soc() {
		return empr_razao_soc;
	}

	public void setEmpr_razao_soc(String empr_razao_soc) {
		this.empr_razao_soc = empr_razao_soc;
	}

	public String getEmpr_nome_fant() {
		return empr_nome_fant;
	}

	public void setEmpr_nome_fant(String empr_nome_fant) {
		this.empr_nome_fant = empr_nome_fant;
	}

	public String getEmpr_endereco() {
		return empr_endereco;
	}

	public void setEmpr_endereco(String empr_endereco) {
		this.empr_endereco = empr_endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empr_cnpj;
		result = prime * result + empr_contato;
		result = prime * result + ((empr_endereco == null) ? 0 : empr_endereco.hashCode());
		result = prime * result + (int) (empr_iden ^ (empr_iden >>> 32));
		result = prime * result + ((empr_nome_fant == null) ? 0 : empr_nome_fant.hashCode());
		result = prime * result + ((empr_razao_soc == null) ? 0 : empr_razao_soc.hashCode());
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
		Empresa other = (Empresa) obj;
		if (empr_cnpj != other.empr_cnpj)
			return false;
		if (empr_contato != other.empr_contato)
			return false;
		if (empr_endereco == null) {
			if (other.empr_endereco != null)
				return false;
		} else if (!empr_endereco.equals(other.empr_endereco))
			return false;
		if (empr_iden != other.empr_iden)
			return false;
		if (empr_nome_fant == null) {
			if (other.empr_nome_fant != null)
				return false;
		} else if (!empr_nome_fant.equals(other.empr_nome_fant))
			return false;
		if (empr_razao_soc == null) {
			if (other.empr_razao_soc != null)
				return false;
		} else if (!empr_razao_soc.equals(other.empr_razao_soc))
			return false;
		return true;
	}

	public Empresa() {
		super();
	}

	public Empresa(long empr_iden, @CNPJ @NotNull int empr_cnpj, @NotNull int empr_contato,
			@NotNull String empr_razao_soc, @NotNull String empr_nome_fant, String empr_endereco) {
		super();
		this.empr_iden = empr_iden;
		this.empr_cnpj = empr_cnpj;
		this.empr_contato = empr_contato;
		this.empr_razao_soc = empr_razao_soc;
		this.empr_nome_fant = empr_nome_fant;
		this.empr_endereco = empr_endereco;
	}

	@Override
	public String toString() {
		return "Empresa [empr_iden=" + empr_iden + ", empr_cnpj=" + empr_cnpj + ", empr_contato=" + empr_contato
				+ ", empr_razao_soc=" + empr_razao_soc + ", empr_nome_fant=" + empr_nome_fant + ", empr_endereco="
				+ empr_endereco + "]";
	}
	
}