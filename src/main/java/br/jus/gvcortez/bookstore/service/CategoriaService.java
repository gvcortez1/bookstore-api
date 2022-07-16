package br.jus.gvcortez.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.exception.ObjectNotFoundException;
import br.jus.gvcortez.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {

		Optional<Categoria> objCategoria = categoriaRepository.findById(id);
		return objCategoria.orElseThrow(() -> 
				new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " - Tipo: " + Categoria.class.getName()));
	}

}
