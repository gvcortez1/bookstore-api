package br.jus.gvcortez.bookstore.dtos;

import java.io.Serializable;

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.dominio.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_livro;

	private String titulo;

	private String nome_autor;

	private String descricao;

	private String texto;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro objLivro) {
		super();
		this.id_livro = objLivro.getid_livro();
		this.titulo = objLivro.getTitulo();
		this.nome_autor = objLivro.getNome_autor();
		this.descricao = objLivro.getDescricao();
		this.texto = objLivro.getTexto();
	}

	public Long getId_livro() {
		return id_livro;
	}

	public void setId_livro(Long id_livro) {
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

}
