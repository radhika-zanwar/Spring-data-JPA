package com.radhika.springdata.associations;

import com.radhika.springdata.associations.onetomany.entities.Customer;
import com.radhika.springdata.associations.onetomany.entities.PhoneNumber;
import com.radhika.springdata.associations.onetoone.entities.License;
import com.radhika.springdata.associations.onetoone.entities.Person;
import com.radhika.springdata.associations.repos.CustomerRepository;
import com.radhika.springdata.associations.repos.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {
	@Autowired
	CustomerRepository repository;
	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("John");
		Set<PhoneNumber> numbers = new HashSet<>();

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("63293479");
		ph1.setType("Cell Phone");
		ph1.setCustomer(customer);

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("56237732");
		ph2.setType("Home");
		ph2.setCustomer(customer);

		numbers.add(ph1);
		numbers.add(ph2);

		customer.setNumbers(numbers);

		repository.save(customer);
	}

	@Test
	@Transactional // added for Lazy loading to work
	public void testLoadCustomer() {
		//find out Optional
		Optional<Customer> customer = repository.findById(252);
		if (customer.isPresent()) {
			System.out.println(customer.get().getName());
			Set<PhoneNumber> numbers = customer.get().getNumbers();
			numbers.spliterator().forEachRemaining(num -> System.out.println("-----------"+num.getNumber()));
		}
		else
			System.out.println("Not found");
	}
	@Test
	public void testUpdateCustomer() {
		//find out Optional
		Optional<Customer> customer = repository.findById(302);
		if (customer.isPresent()) {
			Customer cust = customer.get();
			cust.setName("John Bush");
			Set<PhoneNumber> numbers = cust.getNumbers();
			numbers.spliterator().forEachRemaining(num -> num.setType("Cell"));
			repository.save(cust);
		} else
			System.out.println("Not found");

	}
	@Test
	public void testDeleteCustomer() {
		repository.deleteById(202);
	}

	@Test
	public void testCreateLicense() {
		License license = new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());

		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Clinton");
		person.setAge(40);

		license.setPerson(person);
		licenseRepository.save(license);
	}


}
