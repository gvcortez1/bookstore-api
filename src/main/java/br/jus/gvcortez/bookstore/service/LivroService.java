package br.jus.gvcortez.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.jus.gvcortez.bookstore.dominio.Livro;
import br.jus.gvcortez.bookstore.dtos.LivroDTO;
import br.jus.gvcortez.bookstore.exception.ObjectNotFoundException;
import br.jus.gvcortez.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Long id) {

		Optional<Livro> objLivro = livroRepository.findById(id);
		return objLivro.orElseThrow(() -> 
				new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " - Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {

		return livroRepository.findAll();
	}
	
	public Livro create(Livro objLivro) {
		objLivro.setid_livro(null);
		return livroRepository.save(objLivro);
	}

	public Livro update(Long id, LivroDTO objLivroDTO) {

		Livro objLivro = findById(id);
		
		objLivro.setTitulo(objLivroDTO.getTitulo());
		objLivro.setNome_autor(objLivroDTO.getNome_autor());
		objLivro.setDescricao(objLivroDTO.getDescricao());
		objLivro.setTexto(objLivroDTO.getTexto());
		
		return livroRepository.save(objLivro);
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
