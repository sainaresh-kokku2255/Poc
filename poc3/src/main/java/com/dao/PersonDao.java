package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Person;

public interface PersonDao extends MongoRepository<Person, Integer> {

}
