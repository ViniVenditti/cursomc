package br.com.vinicius.estudo.cursomc.product.repository;

import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
