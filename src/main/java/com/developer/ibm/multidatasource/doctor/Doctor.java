package com.developer.ibm.multidatasource.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctors")
public class Doctor {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Column(name = "specialization")
	private String specialization;

	public Doctor(String fName, String lName, String specialization) {
		this.fName = fName;
		this.lName = lName;
		this.specialization = specialization;
	}

	Doctor() {
	}

	public long getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getSpecialization() {
		return specialization;
	}

}
