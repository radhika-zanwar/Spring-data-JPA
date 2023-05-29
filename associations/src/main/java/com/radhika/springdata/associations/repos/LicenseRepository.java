package com.radhika.springdata.associations.repos;

import com.radhika.springdata.associations.onetoone.entities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License,Integer> {
}
