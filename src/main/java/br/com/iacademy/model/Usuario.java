/** <package br.com.iacademy.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	
	/**
	 * 
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	private String user_login;
	
	private String nome_comp;
	private String user_senha;
	
	public String getNome_comp() {
		return nome_comp;
	}

	public void setNome_comp(String nome_comp) {
		this.nome_comp = nome_comp;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user_senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user_login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
*/