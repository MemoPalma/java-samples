package pe.joedayz.prime.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un articulo. Un articulo es un objeto persistido, por eso sera una entidad.
 * 
 * <p>La demo es sobre un registro (CRUD) de articulos.</p>
 * 
 * <p>Esta entidad es mapeada con anotaciones de <code>JPA</code>,el estandar Java para Mapeo de Objetos Relacional (<code>ORM</code>).</p>
 * 
 * @author JoeDayz
 */
@Entity
@Table(name="mercadoria")
public class Mercadoria implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Integer quantidade;
	
	private Double preco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
