package br.jus.gvcortez.bookstore.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_livro")
public class Livro  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_livro;

	@NotEmpty(message = "Campo TITULO é requerido!")
	@Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "Campo NOME DO AUTOR é requerido!")
	@Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
	private String nome_autor;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requerido!")
	@Length(min = 10, max = 100, message = "O campo DESCRIÇÃO deve ter entre 10 e 100 caracteres")
	private String descricao;
	
	@NotEmpty(message = "Campo TEXTO é requerido!")
	@Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2.000.000 caracteres")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Long id_livro, String titulo, String nome_autor, String descricao, String texto, Categoria categoria) {
		super();
		this.id_livro = id_livro;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.descricao = descricao;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Long getid_livro() {
		return id_livro;
	}

	public void setid_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_livro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id_livro, other.id_livro);
	}

}
