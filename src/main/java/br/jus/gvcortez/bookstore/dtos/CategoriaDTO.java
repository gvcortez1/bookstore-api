package br.jus.gvcortez.bookstore.dtos;

import java.io.Serializable;

import br.jus.gvcortez.bookstore.dominio.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_categoria;

	private String nome;

	private String descricao;

	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria objCategoria) {
		super();
		this.id_categoria = objCategoria.getid_categoria();
		this.nome = objCategoria.getNome();
		this.descricao = objCategoria.getDescricao();
	}

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

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

}
