package br.com.sistema.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Size(max = 20)
	private String nome;
	
	@NonNull
	@Size(max = 85)
	private String email;
	
	@NonNull
	@Size(max = 18)
	private String senha;
	
	/*private boolean ativo;*/
	
	@ManyToMany
	@JoinTable(name="usuario_permissao",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao>permissoes;

	
	/*@OneToMany(mappedBy = "usuario")
	private Set<Comentario>comentarios;*/

	/*@OneToMany(mappedBy = "usuario")
	private Set<Receita>cadastrarReceitas;
	*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/*public Set<Comentario> getComentario(){
		return comentarios;
	}
	
	public void setComentario(Set<Comentario>comentarios) {
		this.comentarios = comentarios;
	}*/

	/*public Set<Receita> getCadastrarReceita(){
		return cadastrarReceitas;
	}
	
	public void setCadastrarReceita(Set<Receita>cadastrarReceitas) {
		this.cadastrarReceitas = cadastrarReceitas;
	}*/
	
	public List<Permissao>getPermissoes(){
		return permissoes;
	}
	
	public void setPermissoes(List<Permissao> permissoes){
		this.permissoes  = permissoes;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" 
	+ email + ", senha=" + senha + "]";
	}


	
	
	
}
