package br.com.sistema.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity(name= "receita")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(max=80)
	private String nome;
	
	@NonNull
	@Size(max=80)
	private String ingredientes;
	
	@NonNull
	private int porcoes;
	
	@NonNull
	private int tempoPreparo;
	
	@NonNull
	@Size(max=1000)
	private String modoPreparo;

	/*@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;*/
	
	@ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
	private Categoria categoria;
	
	/*@ManyToMany(mappedBy = "receitas")
	private List<Comentario>comentarios;*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public int getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(int porcoes) {
		this.porcoes = porcoes;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}
	
	/*public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
	
	/*public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}*/

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ","
				+ " ingredientes=" + ingredientes 
				+ ", porcoes=" + porcoes + ", tempoPreparo=" + tempoPreparo + ","
				+ " modoPreparo=" + modoPreparo + "]";
	}

	

	
}
