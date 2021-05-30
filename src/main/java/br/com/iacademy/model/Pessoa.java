package br.com.iacademy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
/*
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="Pessoa")
@DiscriminatorValue("pes_iden")
*/
public class Pessoa{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*@JoinColumn(name = "pes_iden", referencedColumnName = "pes_iden", insertable = false, updatable = false)*/
	private long pes_iden;
	@NotNull
    private String pes_prim_nome;
	@NotNull
    private String pes_sobrenome;
	
    private String pes_endereco; 
    
    @CPF
    @NotNull
    private long pes_cpf;
    
    private long pes_rg;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String pes_rg_emissao;
    
    @NotNull
    private long pes_telefone; 
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String pes_data_nasc;
    
    @NotNull
	@Enumerated(EnumType.STRING)
    private SexoPessoa sexo;
        
    private String pes_naturalidade;
    
    private String pes_nacionalidade;
    
    private String pes_orient_medic;
    
    @OneToMany
    @JoinColumn(name = "pes_iden") // Esta coluna está na tabela "aluno".
    private List<Aluno> aluno;
    
    @OneToMany
    @JoinColumn(name = "pes_iden") // Esta coluna está na tabela "funcionario".
    private List<Funcionario> funcionario;
    
    public List<Aluno> Aluno() {
        return aluno;
    }
    
    public List<Funcionario> Funcionario() {
        return funcionario;
    }

	public long getPes_iden() {
		return pes_iden;
	}

	public void setPes_iden(long pes_iden) {
		this.pes_iden = pes_iden;
	}

	public String getPes_prim_nome() {
		return pes_prim_nome;
	}

	public void setPes_prim_nome(String pes_prim_nome) {
		this.pes_prim_nome = pes_prim_nome;
	}

	public String getPes_sobrenome() {
		return pes_sobrenome;
	}

	public void setPes_sobrenome(String pes_sobrenome) {
		this.pes_sobrenome = pes_sobrenome;
	}

	public String getPes_endereco() {
		return pes_endereco;
	}

	public void setPes_endereco(String pes_endereco) {
		this.pes_endereco = pes_endereco;
	}

	public long getPes_cpf() {
		return pes_cpf;
	}

	public void setPes_cpf(long pes_cpf) {
		this.pes_cpf = pes_cpf;
	}

	public long getPes_rg() {
		return pes_rg;
	}

	public void setPes_rg(long pes_rg) {
		this.pes_rg = pes_rg;
	}

	public String getPes_rg_emissao() {
		return pes_rg_emissao;
	}

	public void setPes_rg_emissao(String pes_rg_emissao) {
		this.pes_rg_emissao = pes_rg_emissao;
	}

	public long getPes_telefone() {
		return pes_telefone;
	}

	public void setPes_telefone(long pes_telefone) {
		this.pes_telefone = pes_telefone;
	}

	public String getPes_data_nasc() {
		return pes_data_nasc;
	}

	public void setPes_data_nasc(String pes_data_nasc) {
		this.pes_data_nasc = pes_data_nasc;
	}

	public SexoPessoa getSexo() {
		return sexo;
	}

	public void setSexo(SexoPessoa sexo) {
		this.sexo = sexo;
	}

	public String getPes_naturalidade() {
		return pes_naturalidade;
	}

	public void setPes_naturalidade(String pes_naturalidade) {
		this.pes_naturalidade = pes_naturalidade;
	}

	public String getPes_nacionalidade() {
		return pes_nacionalidade;
	}

	public void setPes_nacionalidade(String pes_nacionalidade) {
		this.pes_nacionalidade = pes_nacionalidade;
	}

	public String getPes_orient_medic() {
		return pes_orient_medic;
	}

	public void setPes_orient_medic(String pes_orient_medic) {
		this.pes_orient_medic = pes_orient_medic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (pes_cpf ^ (pes_cpf >>> 32));
		result = prime * result + ((pes_data_nasc == null) ? 0 : pes_data_nasc.hashCode());
		result = prime * result + ((pes_endereco == null) ? 0 : pes_endereco.hashCode());
		result = prime * result + (int) (pes_iden ^ (pes_iden >>> 32));
		result = prime * result + ((pes_nacionalidade == null) ? 0 : pes_nacionalidade.hashCode());
		result = prime * result + ((pes_naturalidade == null) ? 0 : pes_naturalidade.hashCode());
		result = prime * result + ((pes_orient_medic == null) ? 0 : pes_orient_medic.hashCode());
		result = prime * result + ((pes_prim_nome == null) ? 0 : pes_prim_nome.hashCode());
		result = prime * result + (int) (pes_rg ^ (pes_rg >>> 32));
		result = prime * result + ((pes_rg_emissao == null) ? 0 : pes_rg_emissao.hashCode());
		result = prime * result + ((pes_sobrenome == null) ? 0 : pes_sobrenome.hashCode());
		result = prime * result + (int) (pes_telefone ^ (pes_telefone >>> 32));
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (pes_cpf != other.pes_cpf)
			return false;
		if (pes_data_nasc == null) {
			if (other.pes_data_nasc != null)
				return false;
		} else if (!pes_data_nasc.equals(other.pes_data_nasc))
			return false;
		if (pes_endereco == null) {
			if (other.pes_endereco != null)
				return false;
		} else if (!pes_endereco.equals(other.pes_endereco))
			return false;
		if (pes_iden != other.pes_iden)
			return false;
		if (pes_nacionalidade == null) {
			if (other.pes_nacionalidade != null)
				return false;
		} else if (!pes_nacionalidade.equals(other.pes_nacionalidade))
			return false;
		if (pes_naturalidade == null) {
			if (other.pes_naturalidade != null)
				return false;
		} else if (!pes_naturalidade.equals(other.pes_naturalidade))
			return false;
		if (pes_orient_medic == null) {
			if (other.pes_orient_medic != null)
				return false;
		} else if (!pes_orient_medic.equals(other.pes_orient_medic))
			return false;
		if (pes_prim_nome == null) {
			if (other.pes_prim_nome != null)
				return false;
		} else if (!pes_prim_nome.equals(other.pes_prim_nome))
			return false;
		if (pes_rg != other.pes_rg)
			return false;
		if (pes_rg_emissao == null) {
			if (other.pes_rg_emissao != null)
				return false;
		} else if (!pes_rg_emissao.equals(other.pes_rg_emissao))
			return false;
		if (pes_sobrenome == null) {
			if (other.pes_sobrenome != null)
				return false;
		} else if (!pes_sobrenome.equals(other.pes_sobrenome))
			return false;
		if (pes_telefone != other.pes_telefone)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
	
	

	public Pessoa() {
		super();
	}

	
	public Pessoa(long pes_iden, @NotNull String pes_prim_nome, @NotNull String pes_sobrenome, String pes_endereco,
			@NotNull long pes_cpf, long pes_rg, String pes_rg_emissao, @NotNull long pes_telefone, String pes_data_nasc,
			@NotNull SexoPessoa sexo, String pes_naturalidade, String pes_nacionalidade, String pes_orient_medic) {
		super();
		this.pes_iden = pes_iden;
		this.pes_prim_nome = pes_prim_nome;
		this.pes_sobrenome = pes_sobrenome;
		this.pes_endereco = pes_endereco;
		this.pes_cpf = pes_cpf;
		this.pes_rg = pes_rg;
		this.pes_rg_emissao = pes_rg_emissao;
		this.pes_telefone = pes_telefone;
		this.pes_data_nasc = pes_data_nasc;
		this.sexo = sexo;
		this.pes_naturalidade = pes_naturalidade;
		this.pes_nacionalidade = pes_nacionalidade;
		this.pes_orient_medic = pes_orient_medic;
	}

	@Override
	public String toString() {
		return "Pessoa [pes_iden=" + pes_iden + ", pes_prim_nome=" + pes_prim_nome + ", pes_sobrenome=" + pes_sobrenome
				+ ", pes_endereco=" + pes_endereco + ", pes_cpf=" + pes_cpf + ", pes_rg=" + pes_rg + ", pes_rg_emissao="
				+ pes_rg_emissao + ", pes_telefone=" + pes_telefone + ", pes_data_nasc=" + pes_data_nasc + ", sexo="
				+ sexo + ", pes_naturalidade=" + pes_naturalidade + ", pes_nacionalidade=" + pes_nacionalidade
				+ ", pes_orient_medic=" + pes_orient_medic + "]";
	}
    

}