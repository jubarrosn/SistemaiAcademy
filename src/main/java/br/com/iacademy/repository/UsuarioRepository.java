package br.com.iacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iacademy.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsuario (String role);
	
}
