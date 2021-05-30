package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Aluno;

@Repository
@Transactional
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
	
	static Optional<Aluno> findById(int alun_matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//void aluno(long pes_iden, String pes_prim_nome, String pes_sobrenome, String pes_endereco, int pes_cpf,
	//		int pes_rg, int pes_telefone, String pes_rg_emissao, String pes_genero, String pes_data_nasc,
	//		String pes_naturalidade, String pes_nacionalidade, String pes_orient_medic, long alun_pes_iden, long alun_matricula);
	
}

