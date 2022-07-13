package br.jus.gvcortez.bookstore;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.jus.gvcortez.bookstore.dominio.Categoria;
import br.jus.gvcortez.bookstore.dominio.Livro;
import br.jus.gvcortez.bookstore.repositories.CategoriaRepository;
import br.jus.gvcortez.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Categoria 01", "Descrição da Categoria 01");
		Categoria cat2 = new Categoria(null, "Categoria 02", "Descrição da Categoria 02");
		Categoria cat3 = new Categoria(null, "Categoria 03", "Descrição da Categoria 03");
		Categoria cat4 = new Categoria(null, "Categoria 04", "Descrição da Categoria 04");
		Categoria cat5 = new Categoria(null, "Categoria 05", "Descrição da Categoria 05");
		
		Livro livro1 = new Livro(null, "Titulo 01", "Autor 01", "Descrição 01", "Texto 01-01", cat1);
		Livro livro2 = new Livro(null, "Titulo 02", "Autor 02", "Descrição 02", "Texto 02-01", cat2);
		Livro livro3 = new Livro(null, "Titulo 03", "Autor 03", "Descrição 03", "Texto 03-01", cat3);
		Livro livro4 = new Livro(null, "Titulo 04", "Autor 04", "Descrição 04", "Texto 04-01", cat4);
		Livro livro5 = new Livro(null, "Titulo 05", "Autor 05", "Descrição 05", "Texto 05-01", cat5);
		
		cat1.getLivros().addAll(Arrays.asList(livro1));
		cat2.getLivros().addAll(Arrays.asList(livro2));
		cat3.getLivros().addAll(Arrays.asList(livro3));
		cat4.getLivros().addAll(Arrays.asList(livro4));
		cat5.getLivros().addAll(Arrays.asList(livro5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
		
		
	}

}
