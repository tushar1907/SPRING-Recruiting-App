package com.hr.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@Table(name="hr")
@PrimaryKeyJoinColumn(name = "hr_id", referencedColumnName = "user_id")
public class Hr extends User{
	
		

	@Column(name = "HR_Name")
	private String hrName;

	public Hr() {
		
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	
	
}