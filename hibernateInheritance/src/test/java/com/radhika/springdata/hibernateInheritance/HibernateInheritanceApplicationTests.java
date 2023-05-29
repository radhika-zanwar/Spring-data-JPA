package com.radhika.springdata.hibernateInheritance;

import com.radhika.springdata.hibernateInheritance.entities.Cheque;
import com.radhika.springdata.hibernateInheritance.entities.CreditCard;
import com.radhika.springdata.hibernateInheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateInheritanceApplicationTests {
	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreatePayment() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000d);
		cc.setCardnumber("123456");
		repository.save(cc);
	}
	@Test
	public void testCreateChequePayment() {
		Cheque ch = new Cheque();
		ch.setId(124);
		ch.setAmount(1500d);
		ch.setChequeNumber("123789");
		repository.save(ch);
	}



}
