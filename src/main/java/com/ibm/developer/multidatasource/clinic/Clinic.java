package com.ibm.developer.multidatasource.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clinics")
public class Clinic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "city")
	private String city;
	@Column(name = "street_address")
	private String streetAddress;

	Clinic() {
	}

	public Clinic(String name, String city, String streetAddress) {
		this.name = name;
		this.city = city;
		this.streetAddress = streetAddress;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

}
