package com.radhika.springdata.JPQLandNativeSQL;

import com.radhika.springdata.JPQLandNativeSQL.entities.Student;
import com.radhika.springdata.JPQLandNativeSQL.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class JpqLandNativeSqlApplicationTests {
	@Autowired
	StudentRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateStudent() {
		Student student1 = new Student();
		student1.setFirstName("John");
		student1.setLastName("Ferguson");
		student1.setScore(88);
		repository.save(student1);

		Student student2 = new Student();
		student2.setFirstName("Bill");
		student2.setLastName("Gates");
		student2.setScore(75);
		repository.save(student2);

	}
	@Test
	public void testFindAllStudent() {
		System.out.println(repository.findAllStudents());
	}

	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for(Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByScore() {
		System.out.println(repository.findStudentsForGivenScore(70,80));
	}


}
