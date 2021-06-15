/*package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Esporte;

@Repository
@Transactional
public interface EsporteRepository extends JpaRepository<Esporte, Long>{
	
	Optional<Esporte> findById(Long espt_iden);
	
	Optional<Esporte> findByNome(String espt_nome);
	
	//@Query("select p from Esporte p where espt.espt_nome like %?1%")
	//List<Esporte> findByName(String espt_nome);
	
	//@Query("select p from Esporte p where espt.espt_descricao like %?1%")
	//List<Esporte> findByDescrica(String espt_descricao);
	
	//void esporte(long espt_iden, String espt_nome, String espt_descricao);
	
}*/