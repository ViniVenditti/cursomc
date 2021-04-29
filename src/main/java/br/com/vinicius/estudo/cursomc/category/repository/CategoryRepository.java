package br.com.vinicius.estudo.cursomc.category.repository;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
