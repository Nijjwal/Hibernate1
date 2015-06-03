package com.hibernate.inheritancemapping;

import javax.persistence.Entity;

@Entity
public class Task extends Module {
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	private String taskName;

}
