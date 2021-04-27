package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long>{
	
}
