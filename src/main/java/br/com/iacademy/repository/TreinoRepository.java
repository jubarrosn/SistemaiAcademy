package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Treino;

@Repository
@Transactional
public interface TreinoRepository extends JpaRepository<Treino, Long>{

	Optional<Treino> findById(Long treino_iden);
	
	//Optional<Treino> findByDataInicial(Date treino_data_inicial);
	
	//Optional<Treino> findByDataFinal(Date treino_vencimento);
	
	/*@Query("SELECT pes_prim_nome FROM pessoa INNER JOIN treino on pessoa.pes_prim_nome= ?1")
	Treino findByNomeAluno (String pes_prim_nome);
	
	@Query("SELECT pes_sobrenome from pessoa INNER JOIN treino on pessoa.pes_sobrenome =  like %?1%")
	List<Treino> findByLastname(String pes_sobrenome);

	@Query("SELECT pes_prim_nome from pessoa INNER JOIN treino on pessoa.pes_prim_nome =  like %?1%")
	List<Treino> findByName(String pes_prim_nome);*/
	
}