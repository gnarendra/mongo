/**
 * 
 */
package com.starterkit.domain;

import org.springframework.data.annotation.Id;

/**
 * @author ismailibrahim.s@cognizant.com
 *
 */
public class Person {

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */

	@Id
	private String id;

	private String firstName;
	private String lastName;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

}
