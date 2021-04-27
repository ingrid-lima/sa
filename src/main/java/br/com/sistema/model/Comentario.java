package br.com.sistema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity(name="comentario")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(max=500)
	private String mensagem;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name="comentario_cadastrarReceita",
		joinColumns = @JoinColumn(name = "comentario_id"),
		inverseJoinColumns = @JoinColumn(name = "cadastrarReceita_id"))
	private List<Comentario>comentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Comentario>getComentarios(){
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios){
		this.comentarios  = comentarios;
	}
	
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", mensagem=" + mensagem + "]";
	}
	
	

}