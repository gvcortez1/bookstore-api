package br.jus.gvcortez.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.gvcortez.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
