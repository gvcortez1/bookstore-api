package br.jus.gvcortez.bookstore.dtos;

import java.io.Serializable;

import br.jus.gvcortez.bookstore.dominio.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_livro;

	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro objLivro) {
		super();
		this.id_livro = objLivro.getid_livro();
		this.titulo = objLivro.getTitulo();
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

}
