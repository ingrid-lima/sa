package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	
}
