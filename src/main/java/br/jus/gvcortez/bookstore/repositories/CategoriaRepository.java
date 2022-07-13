package br.jus.gvcortez.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.gvcortez.bookstore.dominio.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
