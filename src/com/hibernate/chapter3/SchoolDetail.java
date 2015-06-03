package com.hibernate.chapter3;

import javax.persistence.Embeddable;

@Embeddable
public class SchoolDetail {
	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public boolean isPublicSchool() {
		return isPublicSchool;
	}

	public void setPublicSchool(boolean isPublicSchool) {
		this.isPublicSchool = isPublicSchool;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	private String schoolAddress;
	private boolean isPublicSchool;
	private int studentCount;

}
