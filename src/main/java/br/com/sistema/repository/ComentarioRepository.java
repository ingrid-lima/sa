package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
}