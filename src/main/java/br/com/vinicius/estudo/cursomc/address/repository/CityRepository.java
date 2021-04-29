package br.com.vinicius.estudo.cursomc.address.repository;

import br.com.vinicius.estudo.cursomc.address.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
