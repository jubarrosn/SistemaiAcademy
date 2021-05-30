/**package br.com.iacademy.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.iacademy.model.Usuario;
import br.com.iacademy.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String user_login) throws UsernameNotFoundException {
		Usuario usuario = ur.findByLogin(user_login);
				
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return usuario;
	}
}
*/