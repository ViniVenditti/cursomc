package br.com.vinicius.estudo.cursomc.order.repository;

import br.com.vinicius.estudo.cursomc.order.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
