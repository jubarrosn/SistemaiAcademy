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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
/*
@Table(name="Funcionario")
@PrimaryKeyJoinColumn(referencedColumnName = "pes_iden")
@DiscriminatorValue("pes_iden")
*/
public class Funcionario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long func_iden;
	
	@NotNull
	private long func_cpts; 
	
	@NotNull
	private long func_serie_cpts;
	
	private String func_serie_emissao;
	
	private int func_horario; 
	
	@NotNull
	private long func_pis; 
	
	private long func_cpf_conjuge; 
	
    private long func_cnh;
    
    private String func_cnh_categ;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String func_cnh_validade;
    
    @NotNull
	private String func_escolaridade; 
	
	private String func_nome_conjuge; 	
	
	private String func_nome_mae; 
	
	private String func_nome_pai; 
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String func_admissao; 
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String func_demissao;

	@NotNull
	private EstadoCivil estadoCivil;

	@ManyToOne
    @JoinColumn(name = "pes_iden")
	private Pessoa pessoa;
	
	@OneToMany
    @JoinColumn(name = "func_iden") // Esta coluna está na tabela "professor".
    private List<Professor> professor;
	
	public List<Professor> Professor() {
        return professor;
    }

	public long getFunc_iden() {
		return func_iden;
	}

	public void setFunc_iden(long func_iden) {
		this.func_iden = func_iden;
	}

	public long getFunc_cpts() {
		return func_cpts;
	}

	public void setFunc_cpts(long func_cpts) {
		this.func_cpts = func_cpts;
	}

	public long getFunc_serie_cpts() {
		return func_serie_cpts;
	}

	public void setFunc_serie_cpts(long func_serie_cpts) {
		this.func_serie_cpts = func_serie_cpts;
	}

	public String getFunc_serie_emissao() {
		return func_serie_emissao;
	}

	public void setFunc_serie_emissao(String func_serie_emissao) {
		this.func_serie_emissao = func_serie_emissao;
	}

	public int getFunc_horario() {
		return func_horario;
	}

	public void setFunc_horario(int func_horario) {
		this.func_horario = func_horario;
	}

	public long getFunc_pis() {
		return func_pis;
	}

	public void setFunc_pis(long func_pis) {
		this.func_pis = func_pis;
	}

	public long getFunc_cpf_conjuge() {
		return func_cpf_conjuge;
	}

	public void setFunc_cpf_conjuge(long func_cpf_conjuge) {
		this.func_cpf_conjuge = func_cpf_conjuge;
	}

	public long getFunc_cnh() {
		return func_cnh;
	}

	public void setFunc_cnh(long func_cnh) {
		this.func_cnh = func_cnh;
	}

	public String getFunc_cnh_categ() {
		return func_cnh_categ;
	}

	public void setFunc_cnh_categ(String func_cnh_categ) {
		this.func_cnh_categ = func_cnh_categ;
	}

	public String getFunc_cnh_validade() {
		return func_cnh_validade;
	}

	public void setFunc_cnh_validade(String func_cnh_validade) {
		this.func_cnh_validade = func_cnh_validade;
	}

	public String getFunc_escolaridade() {
		return func_escolaridade;
	}

	public void setFunc_escolaridade(String func_escolaridade) {
		this.func_escolaridade = func_escolaridade;
	}

	public String getFunc_nome_conjuge() {
		return func_nome_conjuge;
	}

	public void setFunc_nome_conjuge(String func_nome_conjuge) {
		this.func_nome_conjuge = func_nome_conjuge;
	}

	public String getFunc_nome_mae() {
		return func_nome_mae;
	}

	public void setFunc_nome_mae(String func_nome_mae) {
		this.func_nome_mae = func_nome_mae;
	}

	public String getFunc_nome_pai() {
		return func_nome_pai;
	}

	public void setFunc_nome_pai(String func_nome_pai) {
		this.func_nome_pai = func_nome_pai;
	}

	public String getFunc_admissao() {
		return func_admissao;
	}

	public void setFunc_admissao(String func_admissao) {
		this.func_admissao = func_admissao;
	}

	public String getFunc_demissao() {
		return func_demissao;
	}

	public void setFunc_demissao(String func_demissao) {
		this.func_demissao = func_demissao;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
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
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((func_admissao == null) ? 0 : func_admissao.hashCode());
		result = prime * result + (int) (func_cnh ^ (func_cnh >>> 32));
		result = prime * result + ((func_cnh_categ == null) ? 0 : func_cnh_categ.hashCode());
		result = prime * result + ((func_cnh_validade == null) ? 0 : func_cnh_validade.hashCode());
		result = prime * result + (int) (func_cpf_conjuge ^ (func_cpf_conjuge >>> 32));
		result = prime * result + (int) (func_cpts ^ (func_cpts >>> 32));
		result = prime * result + ((func_demissao == null) ? 0 : func_demissao.hashCode());
		result = prime * result + ((func_escolaridade == null) ? 0 : func_escolaridade.hashCode());
		result = prime * result + func_horario;
		result = prime * result + (int) (func_iden ^ (func_iden >>> 32));
		result = prime * result + ((func_nome_conjuge == null) ? 0 : func_nome_conjuge.hashCode());
		result = prime * result + ((func_nome_mae == null) ? 0 : func_nome_mae.hashCode());
		result = prime * result + ((func_nome_pai == null) ? 0 : func_nome_pai.hashCode());
		result = prime * result + (int) (func_pis ^ (func_pis >>> 32));
		result = prime * result + (int) (func_serie_cpts ^ (func_serie_cpts >>> 32));
		result = prime * result + ((func_serie_emissao == null) ? 0 : func_serie_emissao.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (func_admissao == null) {
			if (other.func_admissao != null)
				return false;
		} else if (!func_admissao.equals(other.func_admissao))
			return false;
		if (func_cnh != other.func_cnh)
			return false;
		if (func_cnh_categ == null) {
			if (other.func_cnh_categ != null)
				return false;
		} else if (!func_cnh_categ.equals(other.func_cnh_categ))
			return false;
		if (func_cnh_validade == null) {
			if (other.func_cnh_validade != null)
				return false;
		} else if (!func_cnh_validade.equals(other.func_cnh_validade))
			return false;
		if (func_cpf_conjuge != other.func_cpf_conjuge)
			return false;
		if (func_cpts != other.func_cpts)
			return false;
		if (func_demissao == null) {
			if (other.func_demissao != null)
				return false;
		} else if (!func_demissao.equals(other.func_demissao))
			return false;
		if (func_escolaridade == null) {
			if (other.func_escolaridade != null)
				return false;
		} else if (!func_escolaridade.equals(other.func_escolaridade))
			return false;
		if (func_horario != other.func_horario)
			return false;
		if (func_iden != other.func_iden)
			return false;
		if (func_nome_conjuge == null) {
			if (other.func_nome_conjuge != null)
				return false;
		} else if (!func_nome_conjuge.equals(other.func_nome_conjuge))
			return false;
		if (func_nome_mae == null) {
			if (other.func_nome_mae != null)
				return false;
		} else if (!func_nome_mae.equals(other.func_nome_mae))
			return false;
		if (func_nome_pai == null) {
			if (other.func_nome_pai != null)
				return false;
		} else if (!func_nome_pai.equals(other.func_nome_pai))
			return false;
		if (func_pis != other.func_pis)
			return false;
		if (func_serie_cpts != other.func_serie_cpts)
			return false;
		if (func_serie_emissao == null) {
			if (other.func_serie_emissao != null)
				return false;
		} else if (!func_serie_emissao.equals(other.func_serie_emissao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(long func_iden, @NotNull long func_cpts, @NotNull long func_serie_cpts,
			String func_serie_emissao, int func_horario, @NotNull long func_pis, long func_cpf_conjuge, long func_cnh,
			String func_cnh_categ, String func_cnh_validade, @NotNull String func_escolaridade,
			String func_nome_conjuge, String func_nome_mae, String func_nome_pai, @NotNull String func_admissao,
			String func_demissao, @NotNull EstadoCivil estadoCivil, Pessoa pessoa) {
		super();
		this.func_iden = func_iden;
		this.func_cpts = func_cpts;
		this.func_serie_cpts = func_serie_cpts;
		this.func_serie_emissao = func_serie_emissao;
		this.func_horario = func_horario;
		this.func_pis = func_pis;
		this.func_cpf_conjuge = func_cpf_conjuge;
		this.func_cnh = func_cnh;
		this.func_cnh_categ = func_cnh_categ;
		this.func_cnh_validade = func_cnh_validade;
		this.func_escolaridade = func_escolaridade;
		this.func_nome_conjuge = func_nome_conjuge;
		this.func_nome_mae = func_nome_mae;
		this.func_nome_pai = func_nome_pai;
		this.func_admissao = func_admissao;
		this.func_demissao = func_demissao;
		this.estadoCivil = estadoCivil;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [func_iden=" + func_iden + ", func_cpts=" + func_cpts + ", func_serie_cpts="
				+ func_serie_cpts + ", func_serie_emissao=" + func_serie_emissao + ", func_horario=" + func_horario
				+ ", func_pis=" + func_pis + ", func_cpf_conjuge=" + func_cpf_conjuge + ", func_cnh=" + func_cnh
				+ ", func_cnh_categ=" + func_cnh_categ + ", func_cnh_validade=" + func_cnh_validade
				+ ", func_escolaridade=" + func_escolaridade + ", func_nome_conjuge=" + func_nome_conjuge
				+ ", func_nome_mae=" + func_nome_mae + ", func_nome_pai=" + func_nome_pai + ", func_admissao="
				+ func_admissao + ", func_demissao=" + func_demissao + ", estadoCivil=" + estadoCivil + ", pessoa="
				+ pessoa + "]";
	}

}