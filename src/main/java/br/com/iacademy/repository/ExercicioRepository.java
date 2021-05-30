package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Exercicio;

@Repository
@Transactional
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{
	
	Optional<Exercicio> findById(Long id);

	//void exercicio(long exerc_iden, String exerc_nome, String exerc_descrição);
	
}