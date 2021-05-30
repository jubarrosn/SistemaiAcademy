package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Esporte;

@Repository
@Transactional
public interface EsporteRepository extends JpaRepository<Esporte, Long>{
	
	Optional<Esporte> findById(Long id);
	
	//void esporte(long espt_iden, String espt_nome, String espt_descricao);
	
}