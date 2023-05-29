package com.radhika.springdata.hibernateInheritance.repos;

import com.radhika.springdata.hibernateInheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {

}
