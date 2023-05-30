package com.radhika.springdata.productdata;

import com.radhika.springdata.product.entities.Product;
import com.radhika.springdata.product.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
class ProductDataApplicationTests {
	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		repository.save(product);
	}
	@Test
	public void testRead() {
		Product product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	@Test
	public void testUpdate() {
		Product product = repository.findById(2).get();
		product.setPrice(1200d);
		repository.save(product);
	}
	@Test
	public void testDelete() {
		if(repository.existsById(1)) {
			repository.deleteById(1);
		}
	}
	@Test
	public void testCount() {
		System.out.println("Total no of records = " + repository.count());
	}
	@Test
	public void testFindByName() {
		List<Product> product = repository.findByName("IWatch");
		product.forEach(p -> System.out.println(p.getPrice()));
	}
	@Test
	public void testFindByNameAndDesc() {
		List<Product> product = repository.findByNameAndDesc("TV","From Samsung Inc");
		product.forEach(p -> System.out.println(p.getPrice()));
	}
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> product = repository.findByPriceGreaterThan(1000d);
		product.forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindByDescContains() {
		List<Product> product = repository.findByDescContains("Apple");
		product.forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindByPriceBetween() {
		List<Product> product = repository.findByPriceBetween(500d,2500d);
		product.forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindDescLike() {
		List<Product> product = repository.findByDescLike("%LG%");
		product.forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindIdIn() {
		Pageable pageable = PageRequest.of(1,2);
		List<Product> product = repository.findByIdIn(Arrays.asList(1,2,3,4),pageable);
		product.forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(0,2);
		Page<Product> result = repository.findAll(pageable);
		result.forEach(p -> System.out.println(p.getName()));
	}
//	@Test
//	public void testFindAllSorting() {
//		repository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC,"name")),
//						new Sort(new Sort.Order(Sort.Direction.ASC,"price")));
//		//repository.findAll(Sort.by("name","price")).forEach(p -> System.out.println(p.getName()));
//	}
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC,"name");
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}

	@Test
	@Transactional //added for session level Caching
	public void testCaching() {
		repository.findById(1);
		repository.findById(1);
	}

	@Test
	public void testFindAllProducts() {
		System.out.println(repository.findAllProducts());
	}

	@Test
	public void testFindAllProductsByPrice() {
		System.out.println(repository.findAllProductsByPrice(1400));
	}

	@Test
	public void testFindAllProductsCountByPrice() {
		System.out.println(repository.findAllProductsCountByPrice(1400));
	}
}
