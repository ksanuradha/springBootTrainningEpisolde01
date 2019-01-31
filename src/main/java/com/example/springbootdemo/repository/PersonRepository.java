package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springbootdemo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {

}
