package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.CadastrarReceita;

public interface CadastrarReceitaRepository extends JpaRepository<CadastrarReceita, Long>{
	
}