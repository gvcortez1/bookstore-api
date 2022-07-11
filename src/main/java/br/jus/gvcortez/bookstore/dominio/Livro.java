package br.jus.gvcortez.bookstore.dominio;

import java.util.Objects;

public class Livro {

	private Long idLivro;
	private String titulo;
	private String nome_autor;
	private String descricao;
	private String texto;

	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Long idLivro, String titulo, String nome_autor, String descricao, String texto, Categoria categoria) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.descricao = descricao;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
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
		return Objects.hash(idLivro);
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
		return Objects.equals(idLivro, other.idLivro);
	}

}
