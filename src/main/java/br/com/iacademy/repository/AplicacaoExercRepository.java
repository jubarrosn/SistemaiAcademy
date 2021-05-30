package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.AplicacaoExerc;

@Repository
@Transactional
public interface AplicacaoExercRepository extends JpaRepository<AplicacaoExerc, Long>{
	
	Optional<AplicacaoExerc> findById(Long id);
	
	//void aplicacaoExerc(long exerc_iden, String exerc_nome, String exerc_descrição, long aplic_exerc_iden,
	//		String aplic_durancao, String aplic_intensidade, int aplic_repeticoes);
	
}