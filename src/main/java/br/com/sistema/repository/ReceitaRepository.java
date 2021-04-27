package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	
}