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

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.dtos.CategoriaDTO;
import br.jus.gvcortez.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {

		Categoria objCategoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(objCategoria);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> categoriaList = categoriaService.findAll();
		List<CategoriaDTO> categoriaListDTO = categoriaList.stream().map(objCategoria -> new CategoriaDTO(objCategoria))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaListDTO); 
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria objCategoria) {
				
		objCategoria = categoriaService.create(objCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getid_categoria()).toUri();
		
		return ResponseEntity.created(uri).build();	
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO objCategoriaDTO) {

		Categoria newObjCategoria = categoriaService.update(id, objCategoriaDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(newObjCategoria));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
