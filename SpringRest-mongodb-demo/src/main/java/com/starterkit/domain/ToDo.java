/**
 * 
 */
package com.starterkit.domain;

import org.springframework.data.annotation.Id;

/**
 * @author SecureBrowser
 *
 */
public class ToDo {

	/**
	 * @param id
	 * @param taskName
	 * @param takDescription
	 */
	public ToDo(String taskName, String takDescription) {
		this.taskName = taskName;
		this.takDescription = takDescription;
	}
	/**
	 * 
	 */
	public ToDo() {
	}
	@Id
	private String id;
	
	private String taskName;
	private String takDescription;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the takDescription
	 */
	public String getTakDescription() {
		return takDescription;
	}
	/**
	 * @param takDescription the takDescription to set
	 */
	public void setTakDescription(String takDescription) {
		this.takDescription = takDescription;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", taskName=" + taskName + ", takDescription=" + takDescription + "]";
	}
}
