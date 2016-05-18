/**
 * 
 */
package com.starterkit.domain;

import org.springframework.data.annotation.Id;

/**
 * @author Anand.Kittappa@cognizant.com
 *
 */
public class ToDo {

	/**
	 * @param id
	 * @param taskName
	 * @param takDescription
	 */
	public ToDo(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Default controller
	 */
	public ToDo() {
	}

	@Id
	private String id;

	private String taskName;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", taskName=" + taskName + "]";
	}
}
