package com.hr.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "user_id")
public class Student extends User{
	
	

	@Column(name = "student_Name")
	private String studentName;

	public Student() {	
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	
	
	
}