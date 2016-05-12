/**
 * 
 */
package com.starterkit.dto;

/**
 * @author ismailibrahim.s@cognizant.com
 *
 */
public class PersonDTO {

	private String id;

	private String firstName;
	private String lastName;

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonDTO(String firstName, String lastName) {
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

}
