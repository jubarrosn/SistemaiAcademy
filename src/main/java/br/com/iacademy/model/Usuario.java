/*package br.com.iacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario  implements Serializable{

    /**
	 * 
	 * /
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    //@OneToMany
    //@JoinColumn(name = "pes_iden")
    //private Collection<Pessoa> pessoa;

    public Usuario() {

    }

    public Usuario(String role){
        this.role = role;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    / *public Collection<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(Collection<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }* /

	public String getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
}*/