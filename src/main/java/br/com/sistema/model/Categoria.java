package br.com.sistema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NonNull
	@Size
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cadastrarReceita_id", nullable = false)
	private CadastrarReceita cadastrarReceita;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CadastrarReceita getCadastrarReceita() {
		return cadastrarReceita;
	}
	
	public void setCadastrarReceita(CadastrarReceita cadastrarReceita) {
		this.cadastrarReceita = cadastrarReceita;
	}

	@Override
	public String toString() {
		return "Categoria [Id=" + Id + ", nome=" + nome + "]";
	}

	
	
}
