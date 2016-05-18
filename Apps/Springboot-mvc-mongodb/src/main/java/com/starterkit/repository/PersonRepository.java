/**
 * 
 */
package com.starterkit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starterkit.domain.Person;

/**
 * @author ismailibrahim.s@cognizant.com. MongoRepository reads system
 *         environment variables (VCAP_SERVICE) and establish a connection with
 *         DB using connection parameters. It creates a collection 'Person'
 *         (domain class passed as an argument). Its having build-in methods for
 *         CRUD operation.
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
