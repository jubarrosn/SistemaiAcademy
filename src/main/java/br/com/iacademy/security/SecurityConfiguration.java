package br.com.iacademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.iacademy.config.SSUserDetailsService;
import br.com.iacademy.repository.PessoaRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(pessoaRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/templates/erro.html", "/webjars/**").permitAll()
        		.antMatchers("/h2-console/**").permitAll()
        		.antMatchers("/resources/**", "/webjars/**").permitAll()
                .antMatchers("/src/main/resources/static/materialize/css/csstelalogin.css", "** /recources/static/materialize/css/csstelalogin.css/**","/images/**","/js/**", "/", "/index", "/login").permitAll()
                .antMatchers("/homeAdm","/formAddAlunoAdm", "/pagamentos", "/formAddFuncionario", "/formAddProfessor", "errorAdm").access("hasAuthority('ADMIN')")
                .antMatchers("/homeProfessor").access("hasAuthority('PROFESSOR')")
                .antMatchers("/homeAluno", "/visualizarTreino").access("hasAuthority('ALUNO')")
                .anyRequest().authenticated()
                	.and().formLogin()
                		.loginPage("/login").permitAll()
                .and()
                	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                	.logoutSuccessUrl("/login").permitAll()
                .and()
    				.rememberMe();

        http.csrf().disable();
        http.headers().frameOptions().disable();
                    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
      auth.inMemoryAuthentication()
                .withUser("aluno").password(passwordEncoder().encode("iacademyaluno"))
                .authorities("ALUNO")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("iacademyadmin"))
                .authorities("ADMIN")
                .and()
                .withUser("professor")
                .password(passwordEncoder().encode("iacademyprofessor"))
                .authorities("PROFESSOR");
        auth.userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());
    }

	public SSUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(SSUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
