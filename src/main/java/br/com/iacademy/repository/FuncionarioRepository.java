package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Funcionario;

@Repository
@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Optional<Funcionario> findById(Long id);
	
	//void funcionario(long func_pes_iden, long func_empr_iden, long func_crg_iden, long func_cpts,
	//		long func_serie_cpts, int func_horario, long func_pis, long func_cpf_conjuge, long func_cnh,
	//		String func_cnh_categ, String func_cnh_validade, String func_serie_emissao, String func_escolaridade,
	//		String func_est_civil, String func_nome_conjuge, String func_nome_mae, String func_nome_pai,
	//		String func_admissao, String func_demissao);
	
}