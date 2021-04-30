package br.com.vinicius.estudo.cursomc.order.repository;

import br.com.vinicius.estudo.cursomc.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
