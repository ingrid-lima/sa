package br.com.sistema.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity(name = "classificacao")
public class Classificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(max=5)
	private int nota;

	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "classificacao")
	private Set<Receita> receitas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Receita> getReceita(){
		return receitas;
	}
	
	public void setReceitas(Set<Receita>receitas) {
		this.receitas = receitas;
	}
	
	@Override
	public String toString() {
		return "Classificacao [id=" + id + ", nota=" + nota + "]";
	}
	
	

}
