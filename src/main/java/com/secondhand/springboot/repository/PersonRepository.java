package com.secondhand.springboot.repository;

import com.secondhand.springboot.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
