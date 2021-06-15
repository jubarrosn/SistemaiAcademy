/*package br.com.iacademy.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.iacademy.model.Pessoa;
import br.com.iacademy.model.Usuario;
import br.com.iacademy.repository.PessoaRepository;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {

	
	
    private PessoaRepository pessoaRepository;

    public SSUserDetailsService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @SuppressWarnings("unused")
	public UserDetails loadPessoaByPes_cpf(String pes_cpf) throws UsernameNotFoundException {
        try {
            List<Pessoa> pessoa = pessoaRepository.findByCPF(pes_cpf);
            if(pes_cpf==null){
            	throw new UsernameNotFoundException("Usuário não encontrado!");
            }
            return new UserDetails() {
				
				/**
				 * 
				 * /
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isCredentialsNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonLocked() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean isAccountNonExpired() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public String getUsername() {
					// TODO Auto-generated method stub
					return pes_cpf;
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					return null;
				}
			}; //UserDetails(pessoa.getPes_cpf(), pessoa.getPassword(), getAuthories(pessoa));
        }

        catch (Exception e)
        {
         throw new UsernameNotFoundException("Usuário Não encontrado!");
        }
    }

    protected abstract Object authorities(List<Pessoa> pessoa);

	@SuppressWarnings("unused")
	private Set<GrantedAuthority> getAuthories(Pessoa pessoa){

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Usuario usuario: pessoa.getUsuario()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getUsuario());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

	public UserDetails loadUserByUsername(Long pes_cpf) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
*/