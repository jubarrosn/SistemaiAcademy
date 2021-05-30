package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Treino;

@Repository
@Transactional
public interface TreinoRepository extends CrudRepository<Treino, Long>{

	Optional<Treino> findById(Long id);
	 
	// void treino(long treino_iden);
}