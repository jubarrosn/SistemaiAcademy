package br.com.iacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iacademy.model.Aluno;

@Repository
@Transactional
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Optional<Aluno> findById(Integer alun_matricula);
	
	
	/*@Query("SELECT pes_prim_nome FROM Pessoa INNER JOIN Aluno ON Pessoa.pes_prim_nome= ?1")
	Aluno findByNomeAluno (String pes_prim_nome);
	
	@Query("SELECT pes_sobrenome FROM Pessoa INNER JOIN Aluno ON Pessoa.pes_sobrenome =  like %?1%")
	List<Aluno> findByLastname(String pes_sobrenome);

	@Query("SELECT pes_prim_nome FROM Pessoa INNER JOIN Aluno ON Pessoa.pes_prim_nome =  like %?1%")
	List<Aluno> findByName(String pes_prim_nome);

	@Query("SELECT pes_prim_nome FROM Pessoa INNER JOIN Aluno ON Pessoa.pes_iden= ?1")
	List<Aluno> findByListNome(String pes_sobrenome);*/
	
	//@Query("select * from pessoa inner join aluno on pessoa.pes_iden='?1'")
	//List<Aluno> findByPessoaToda(String pes_sobrenome);
	
	//@Query("select * from aluno inner join pessoa on pessoa.pes_iden='?1'")
	//List<Aluno> findByToda(String pes_sobrenome);
}