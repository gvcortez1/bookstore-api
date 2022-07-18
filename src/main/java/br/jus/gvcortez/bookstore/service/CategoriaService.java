package br.jus.gvcortez.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.dtos.CategoriaDTO;
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

	public List<Categoria> findAll() {

		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria objCategoria) {
		objCategoria.setid_categoria(null);
		return categoriaRepository.save(objCategoria);
	}

	public Categoria update(Long id, CategoriaDTO objCategoriaDTO) {

		Categoria objCategoria = findById(id);
		objCategoria.setNome(objCategoriaDTO.getNome());
		objCategoria.setDescricao(objCategoriaDTO.getDescricao());
		
		return categoriaRepository.save(objCategoria);
	}

}
