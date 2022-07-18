package br.jus.gvcortez.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.gvcortez.bookstore.dominio.Livro;
import br.jus.gvcortez.bookstore.dtos.LivroDTO;
import br.jus.gvcortez.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {

		Livro objLivro = livroService.findById(id);
		return ResponseEntity.ok().body(objLivro);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {

		List<Livro> livroList = livroService.findAll();
		List<LivroDTO> livroListDTO = livroList.stream().map(objLivro -> new LivroDTO(objLivro))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(livroListDTO); 
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestBody Livro objLivro) {
				
		objLivro = livroService.create(objLivro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objLivro.getid_livro()).toUri();
		
		return ResponseEntity.created(uri).build();	
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO objLivroDTO) {

		Livro newObjLivro = livroService.update(id, objLivroDTO);
		return ResponseEntity.ok().body(new LivroDTO(newObjLivro));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
