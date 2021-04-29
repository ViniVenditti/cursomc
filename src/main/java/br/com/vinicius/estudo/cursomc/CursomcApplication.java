package br.com.vinicius.estudo.cursomc;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import br.com.vinicius.estudo.cursomc.product.entity.repository.ProductRepository;
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
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
	}
}
