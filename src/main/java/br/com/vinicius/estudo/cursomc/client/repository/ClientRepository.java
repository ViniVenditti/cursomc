package br.com.vinicius.estudo.cursomc.client.repository;

import br.com.vinicius.estudo.cursomc.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
