package com.radhika.springdata.associations.repos;

import com.radhika.springdata.associations.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
