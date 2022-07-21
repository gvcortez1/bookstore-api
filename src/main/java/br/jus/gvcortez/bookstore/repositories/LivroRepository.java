package br.jus.gvcortez.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.jus.gvcortez.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("select obj from Livro obj where obj.categoria.id_categoria = :id_cat order by titulo ")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Long id_cat);

}
