package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Professor;

@Repository
@Transactional
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	Optional<Professor> findById(Long id);
	
	//void professor(long pes_iden, String pes_prim_nome, String pes_sobrenome, String pes_endereco, int pes_cpf,
	//		int pes_rg, int pes_telefone, String pes_rg_emissao, String pes_genero, String pes_data_nasc,
	//		String pes_naturalidade, String pes_nacionalidade, String pes_orient_medic, String prof_confef,
	//		long prof_pes_iden);
	
}
