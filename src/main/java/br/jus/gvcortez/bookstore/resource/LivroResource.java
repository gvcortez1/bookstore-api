package br.jus.gvcortez.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {

		List<Livro> livroList = livroService.findAll(id_cat);
		List<LivroDTO> livroListDTO = livroList.stream().map(objLivro -> new LivroDTO(objLivro))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(livroListDTO); 
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat, 
											@RequestBody Livro objLivro) {
				
		objLivro = livroService.create(id_cat, objLivro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").
						buildAndExpand(objLivro.getid_livro()).toUri();
		
		return ResponseEntity.created(uri).build();	
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro objLivro) {

		Livro newObjLivro = livroService.update(id, objLivro);
		return ResponseEntity.ok().body(newObjLivro);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro objLivro) {

		Livro newObjLivro = livroService.update(id, objLivro);
		return ResponseEntity.ok().body(newObjLivro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
