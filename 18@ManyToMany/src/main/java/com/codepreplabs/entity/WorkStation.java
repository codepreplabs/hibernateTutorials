package com.codepreplabs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class WorkStation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workstationId;

	private String operatingSystem;
	private String hardware;
	
	@ManyToMany(mappedBy="workStations")
	private List<Employee> employees = new ArrayList<Employee>();

	public int getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(int workstationId) {
		this.workstationId = workstationId;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
