package com.radhika.springdata.JPQLandNativeSQL.repos;

import com.radhika.springdata.JPQLandNativeSQL.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select firstName, lastName from Student")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentsForGivenScore(@Param("min") int min, @Param("max") int max);

}
