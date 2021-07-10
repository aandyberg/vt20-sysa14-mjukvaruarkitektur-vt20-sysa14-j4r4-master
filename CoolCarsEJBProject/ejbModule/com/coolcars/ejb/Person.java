package com.coolcars.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Person.findAllPersons", query="SELECT p FROM Person p"),
})
@Table(name="Person")
public class Person implements Serializable{

	private String pId;
	private String name;
	private String email;
	private String password;
	private Set<Car> cars;
	
	@Id
	@Column(name="pId")
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="pPassword")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinTable(name="OwnsCar", joinColumns = @JoinColumn(name="pId", referencedColumnName = "pID"), inverseJoinColumns = @JoinColumn(name="licenseNbr", referencedColumnName = "licenseNbr"))
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	

}
