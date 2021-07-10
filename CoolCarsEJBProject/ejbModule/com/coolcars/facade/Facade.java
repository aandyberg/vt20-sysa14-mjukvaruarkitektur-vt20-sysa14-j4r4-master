package com.coolcars.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.coolcars.eao.CarEAOLocal;
import com.coolcars.eao.PersonEAOLocal;
import com.coolcars.ejb.Car;
import com.coolcars.ejb.Person;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

    /**
     * Default constructor. 
     */
	@EJB
	private PersonEAOLocal personEAO;
	@EJB
	private CarEAOLocal carEAO;
	
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    
    public Person findByPersonPId(String pId) {
    	return personEAO.findByPersonPId(pId);
    }
    public Person createPerson(Person person) {
    	return personEAO.createPerson(person);
    }
    public Person updatePerson(Person person) {
    	return personEAO.updatePerson(person);
    }
    public void deletePerson(String pId) {
    	personEAO.deletePerson(pId);
    }
    public List<Person> findAllPersons() {
    	return personEAO.findAllPersons();
    }
    
    public Car findByLicenseNbr(String licenseNbr) {
    	return carEAO.findByLicenseNbr(licenseNbr);
    }
    public Car createCar(Car car) {
    	return carEAO.createCar(car);
    }
    public Car updateCar(Car car) {
    	return carEAO.updateCar(car);
    }
    public void deleteCar(String licenseNbr) {
    	carEAO.deleteCar(licenseNbr);
    }
    public List<Car> findAll() {
    	return carEAO.findAll();
    }

}
