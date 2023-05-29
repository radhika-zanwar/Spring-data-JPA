package com.radhika.springdata.associations.repos;

import com.radhika.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
