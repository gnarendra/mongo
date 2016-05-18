/**
 * 
 */
package com.starterkit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starterkit.domain.Person;

/**
 * @author ismailibrahim.s@cognizant.com creating DB and establishing connection
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
