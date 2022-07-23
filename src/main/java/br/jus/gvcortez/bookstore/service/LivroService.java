package br.jus.gvcortez.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.dominio.Livro;
import br.jus.gvcortez.bookstore.exception.ObjectNotFoundException;
import br.jus.gvcortez.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {

		Optional<Livro> objLivro = livroRepository.findById(id);
		return objLivro.orElseThrow(() -> 
				new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " - Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {

		categoriaService.findById(id_cat);
		
		return livroRepository.findAllByCategoria(id_cat);
	}
	
	public Livro create(Long id_cat, Livro objLivro) {
		objLivro.setid_livro(null);
		Categoria categoria = categoriaService.findById(id_cat);
		objLivro.setCategoria(categoria);
		return livroRepository.save(objLivro);
	}

	public Livro update(Long id, Livro objLivro) {

		Livro objLivroNew = findById(id);
		
		updateData(objLivroNew, objLivro);
		
		return livroRepository.save(objLivroNew);
	}

	private void updateData(Livro objLivroNew, Livro objLivro) {

		objLivroNew.setTitulo(objLivro.getTitulo());
		objLivroNew.setNome_autor(objLivro.getNome_autor());
		objLivroNew.setDescricao(objLivro.getDescricao());
	}

	public void delete(Long id) {

		findById(id);
		
		try {
			livroRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.jus.gvcortez.bookstore.resource.exception.DataIntegrityViolationException("Livro não pode ser deletado! Possui categorias associadas.");
		}
	}

}
