package br.com.vinicius.estudo.cursomc;

import br.com.vinicius.estudo.cursomc.address.entity.AddressEntity;
import br.com.vinicius.estudo.cursomc.address.entity.CityEntity;
import br.com.vinicius.estudo.cursomc.address.entity.StateEntity;
import br.com.vinicius.estudo.cursomc.address.repository.AddressRepository;
import br.com.vinicius.estudo.cursomc.address.repository.CityRepository;
import br.com.vinicius.estudo.cursomc.address.repository.StateRepository;
import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import br.com.vinicius.estudo.cursomc.client.entity.ClientEntity;
import br.com.vinicius.estudo.cursomc.client.repository.ClientRepository;
import br.com.vinicius.estudo.cursomc.enums.ClientType;
import br.com.vinicius.estudo.cursomc.enums.StatePayment;
import br.com.vinicius.estudo.cursomc.order.entity.*;
import br.com.vinicius.estudo.cursomc.order.repository.OrderItemRepository;
import br.com.vinicius.estudo.cursomc.order.repository.OrderRepository;
import br.com.vinicius.estudo.cursomc.order.repository.PaymentRepository;
import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import br.com.vinicius.estudo.cursomc.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoryEntity cat1 = new CategoryEntity("Inform??tica");
		CategoryEntity cat2 = new CategoryEntity("Escrit??rio");
		CategoryEntity cat3 = new CategoryEntity("Cama mesa e banho");
		CategoryEntity cat4 = new CategoryEntity("Eletr??nicos");
		CategoryEntity cat5 = new CategoryEntity("Jardinagem");
		CategoryEntity cat6 = new CategoryEntity("Decora????o");
		CategoryEntity cat7 = new CategoryEntity("Perfumaria");
		ProductEntity prod1 = new ProductEntity(null, "Computador", 2000.00);
		ProductEntity prod2 = new ProductEntity(null, "Impressora", 800.00);
		ProductEntity prod3 = new ProductEntity(null, "mouse", 80.00);
		StateEntity e1 = new StateEntity(null, "Minas Gerais");
		StateEntity e2 = new StateEntity(null, "S??o Paulo");
		CityEntity c1 = new CityEntity(null, "Uberl??ndia", e1);
		CityEntity c2 = new CityEntity(null, "S??o Paulo", e2);
		CityEntity c3 = new CityEntity(null, "Campinas", e2);
		ClientEntity cli1 = new ClientEntity(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PERSON);
		AddressEntity add1 = new AddressEntity(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		AddressEntity add2 = new AddressEntity(null, "Avenida Matos", "105", "sala 800", "Centro", "38777012", cli1, c2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		OrderEntity o1 = new OrderEntity(null, sdf.parse("30/04/2020 10:32"), cli1, add1);
		OrderEntity o2 = new OrderEntity(null, sdf.parse("10/10/2020 19:35"), cli1, add2);
		PaymentEntity p1 = new PaymentCardEntity(null, StatePayment.SETTLED, o1, 6);
		PaymentEntity p2 = new PaymentSlipEntity(null, StatePayment.PENDING, o2, sdf.parse("20/10/2020 00:00"), null);
		OrderItemEntity i1 = new OrderItemEntity(o1, prod1, 0.00, 1, 2000.00);
		OrderItemEntity i2 = new OrderItemEntity(o1, prod3, 0.00, 2, 80.00);
		OrderItemEntity i3 = new OrderItemEntity(o2, prod2, 100.00, 1, 800.00);

		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat1));
		prod1.getItems().addAll(Arrays.asList(i1));
		prod2.getItems().addAll(Arrays.asList(i3));
		prod3.getItems().addAll(Arrays.asList(i2));
		e1.getCities().addAll(Arrays.asList(c1));
		e2.getCities().addAll(Arrays.asList(c2,c3));
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getAddresses().addAll(Arrays.asList(add1, add2));
		o1.setPayment(p1);
		o2.setPayment(p2);
		o1.getItems().addAll(Arrays.asList(i1, i2));
		o2.getItems().addAll(Arrays.asList(i3));
		cli1.getOrders().addAll(Arrays.asList(o1, o2));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		stateRepository.saveAll(Arrays.asList(e1,e2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(add1, add2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		paymentRepository.saveAll(Arrays.asList(p1, p2));
		orderItemRepository.saveAll(Arrays.asList(i1, i2, i3));
	}
}
