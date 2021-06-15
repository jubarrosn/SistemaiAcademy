/*package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.AplicacaoExerc;

@Repository
@Transactional
public interface AplicacaoExercRepository extends JpaRepository<AplicacaoExerc, Long>{
	
	Optional<AplicacaoExerc> findById(Long aplic_iden);
}	
	/*@Query("select p from AplicacaoExerc p where aplic.aplic_duracao like %?1%")
	List<AplicacaoExerc> findByDuracao(String aplic_duracao);
	
	@Query("select p from AplicacaoExerc p where aplic.aplic_intensidade like %?1%")
	List<AplicacaoExerc> findByIntensidade(String aplic_intensidade);
	
	@Query("select p from AplicacaoExerc p where aplic.aplic_repeticoes like %?1%")
	List<AplicacaoExerc> findByRepeticao(int aplic_duracao);
	
	//void aplicacaoExerc(long exerc_iden, String exerc_nome, String exerc_descrição, long aplic_exerc_iden,
	//		String aplic_durancao, String aplic_intensidade, int aplic_repeticoes);
	
}*/