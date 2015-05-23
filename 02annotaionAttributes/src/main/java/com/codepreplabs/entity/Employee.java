package com.codepreplabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="EMPLOYEE_DETAILS")
public class Employee {

/*	@Id
	@Column (name="EMPLOYEE_ID")*/
	private int employeeId;
	
//	@Column (name="EMPLOYEE_FNAME")
	private String firstName;
	
//	@Column (name="EMPLOYEE_LNAME")
	private String lastname;
	
	@Id
	@Column (name="EMPLOYEE_ID")
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column (name="EMPLOYEE_FNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column (name="EMPLOYEE_LNAME")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
