package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
