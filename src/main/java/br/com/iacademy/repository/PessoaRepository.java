package br.com.iacademy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	Optional<Pessoa> findById(Long id);
	
	@Query("select p from Pessoa p where p.pes_prim_nome like %?1%")
	List<Pessoa> findPessoaByName(String pes_prim_nome);

	
}
