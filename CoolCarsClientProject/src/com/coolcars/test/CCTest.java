package com.coolcars.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.coolcars.facade.FacadeLocal;
import com.coolcars.ejb.*;

import junit.framework.TestCase;

public class CCTest extends TestCase {
	
	FacadeLocal facade;

	public CCTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		facade = (FacadeLocal)context.lookup("java:app/CoolCarsEJBProject/Facade!com.coolcars.facade.FacadeLocal");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
	}
	
	public void testMethodPerson() throws Exception {
		Person person = new Person();
		person.setpId("1234567890");
		person.setName("jUnit");
		person.setEmail("jUnit@email.com");
		person.setPassword("password");
		facade.createPerson(person);
		assertEquals(facade.findByPersonPId(person.getpId()).getpId(), "1234567890");
		assertEquals(facade.findByPersonPId(person.getpId()).getName(), "jUnit");
		assertEquals(facade.findByPersonPId(person.getpId()).getEmail(), "jUnit@email.com");
		assertEquals(facade.findByPersonPId(person.getpId()).getPassword(), "password");
		person.setName("Bosse");
		facade.updatePerson(person);
		assertEquals(facade.findByPersonPId(person.getpId()).getName(), "Bosse");
		if(facade.findByPersonPId(person.getpId()) != null) {
			facade.deletePerson(person.getpId());
		}
		assertNull(facade.findByPersonPId(person.getpId()));
		
	}
	
	public void testMethodCar() throws Exception {
		Car car = new Car();
		car.setLicenseNbr("jUnit1");
		car.setBrand("tesla");
		car.setPrice(1000);
		facade.createCar(car);
		assertEquals(facade.findByLicenseNbr(car.getLicenseNbr()).getLicenseNbr(), "jUnit1");
		assertEquals(facade.findByLicenseNbr(car.getLicenseNbr()).getBrand(), "tesla");
		assertEquals(facade.findByLicenseNbr(car.getLicenseNbr()).getPrice(), Integer.valueOf(1000));
		car.setBrand("Volvo");
		facade.updateCar(car);
		assertEquals(facade.findByLicenseNbr(car.getLicenseNbr()).getBrand(), "Volvo");
		if(facade.findByLicenseNbr(car.getLicenseNbr()) != null) {
			facade.deleteCar(car.getLicenseNbr());
		}
		assertNull(facade.findByLicenseNbr(car.getLicenseNbr()));
		
	}

}
