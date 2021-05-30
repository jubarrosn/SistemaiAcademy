package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Cargo;

@Repository
@Transactional
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	Optional<Cargo> findById(Long id);
	//void cargo(long crg_iden, String crg_nome, String crg_funcao, double crg_salario);

}

