package com.radhika.springdata.idGenerators.repos;

import com.radhika.springdata.idGenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
