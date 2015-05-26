package com.codepreplabs.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.codeprep.vo.AddressVO;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String firstName;
	private String lastname;

	@Temporal(TemporalType.TIME)
	private Date dateOfBirth;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine", column = @Column(name = "PERMANENT_ADDRESS_LINE")),
			@AttributeOverride(name = "city", column = @Column(name = "PERMANENT_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "PERMANENT_STATE")),
			@AttributeOverride(name = "country", column = @Column(name = "PERMANENT_COUNTRY")), })
	private AddressVO permanentAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine", column = @Column(name = "TEMP_ADDRESS_LINE")),
			@AttributeOverride(name = "city", column = @Column(name = "TEMP_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "TEMP_STATE")),
			@AttributeOverride(name = "country", column = @Column(name = "TEMP_COUNTRY")), })
	private AddressVO currentAddress;

	public AddressVO getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(AddressVO permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public AddressVO getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(AddressVO currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date date) {
		this.dateOfBirth = date;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
