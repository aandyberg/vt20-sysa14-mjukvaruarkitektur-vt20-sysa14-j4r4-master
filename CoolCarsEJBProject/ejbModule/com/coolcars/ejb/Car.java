package com.coolcars.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({
	@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
})
@Table(name="Car")
public class Car implements Serializable{

	private String licenseNbr;
	private String brand;
	private Integer price;
	private Set<Person> persons;
	
	@Id
	@Column(name="licenseNbr")
	public String getLicenseNbr() {
		return licenseNbr;
	}
	public void setLicenseNbr(String licenseNbr) {
		this.licenseNbr = licenseNbr;
	}
	@Column(name="brand")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column(name="price")
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE, mappedBy="cars")
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
