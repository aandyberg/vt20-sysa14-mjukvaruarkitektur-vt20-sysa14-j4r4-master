package com.coolcars.facade;

import java.util.List;

import javax.ejb.Local;

import com.coolcars.ejb.Car;
import com.coolcars.ejb.Person;

@Local
public interface FacadeLocal {
	public Person findByPersonPId(String pId);
	public Person createPerson(Person person);
	public Person updatePerson(Person person);
	public void deletePerson(String pId);
	public List<Person> findAllPersons();
	
	public Car findByLicenseNbr(String licenseNbr);
	public Car createCar(Car car);
	public Car updateCar(Car car);
	public void deleteCar(String licenseNbr);
	public List<Car> findAll();
}
