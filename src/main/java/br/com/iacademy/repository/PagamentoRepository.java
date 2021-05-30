package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Pagamento;

@Repository
@Transactional
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	Optional<Pagamento> findById(Long id);
	
	//void pagamento(long pagm_iden, float pagm_valor, String pagm_data, String pagm_data_venc);
	
}
