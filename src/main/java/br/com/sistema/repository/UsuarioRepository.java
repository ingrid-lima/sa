package br.com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long>{

}
