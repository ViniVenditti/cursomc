package br.com.vinicius.estudo.cursomc;

import br.com.vinicius.estudo.cursomc.address.entity.CityEntity;
import br.com.vinicius.estudo.cursomc.address.entity.StateEntity;
import br.com.vinicius.estudo.cursomc.address.repository.CityRepository;
import br.com.vinicius.estudo.cursomc.address.repository.StateRepository;
import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import br.com.vinicius.estudo.cursomc.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoryEntity cat1 = new CategoryEntity("Informática");
		CategoryEntity cat2 = new CategoryEntity("Escritório");
		ProductEntity prod1 = new ProductEntity(null, "Computador", 2000.00);
		ProductEntity prod2 = new ProductEntity(null, "Impressora", 800.00);
		ProductEntity prod3 = new ProductEntity(null, "mouse", 80.00);
		StateEntity e1 = new StateEntity(null, "Minas Gerais");
		StateEntity e2 = new StateEntity(null, "São Paulo");
		CityEntity c1 = new CityEntity(null, "Uberlândia", e1);
		CityEntity c2 = new CityEntity(null, "São Paulo", e2);
		CityEntity c3 = new CityEntity(null, "Campinas", e2);

		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));
		e1.getCities().addAll(Arrays.asList(c1));
		e2.getCities().addAll(Arrays.asList(c2,c3));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		stateRepository.saveAll(Arrays.asList(e1,e2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));

	}
}
