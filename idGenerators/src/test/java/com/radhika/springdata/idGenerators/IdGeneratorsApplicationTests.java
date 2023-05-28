package com.radhika.springdata.idGenerators;

import com.radhika.springdata.idGenerators.entities.Employee;
import com.radhika.springdata.idGenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdGeneratorsApplicationTests {
	@Autowired
	EmployeeRepository er;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("John");
		er.save(employee);
	}
}
