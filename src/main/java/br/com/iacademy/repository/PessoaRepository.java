package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	Optional<Pessoa> findById(Long id);
	
	//Optional<Pessoa> findByPes_prim_nome(String pes_prim_nome);
	
	//Optional<Pessoa> findByCPF(long pes_cpf);
	
	
	/*@Query("SELECT p FROM Pessoa p WHERE Pessoa.pes_prim_nome LIKE %?1%")
	List<Pessoa> findPessoaByName(String pes_prim_nome);
	
	@Query("SELECT pes_sobrenome FROM Pessoa WHERE Pessoa.pes_sobrenome LIKE %?1%")
	List<Pessoa> findByLastname(String pes_sobrenome);

	@Query("SELECT pes_cpf FROM Pessoa WHERE Pessoa.pes_cpf LIKE %?1%")
	List<Pessoa> findByCPF(Long pes_cpf);*/
	
	//Pessoa findByPes_cpf(Long pes_cpf);
	//Pessoa findByCPF(long pes_cpf);
}
