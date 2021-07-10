package com.coolcars.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.coolcars.ejb.Car;

/**
 * Session Bean implementation class CarEAOImpl
 */
@Stateless
public class CarEAOImpl implements CarEAOLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "CoolCarsEJBSql")
	private EntityManager em;
	
    public CarEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Car findByLicenseNbr(String licenseNbr) {
    	return em.find(Car.class, licenseNbr);
    }
    public Car createCar(Car car) {
    	em.persist(car);
    	return car;
    }
    public Car updateCar(Car car) {
    	em.merge(car);
    	return car;
    }
    public void deleteCar(String licenseNbr) {
    	Car c = this.findByLicenseNbr(licenseNbr);
    	if (c != null) {
    		em.remove(c);
    	}
    }
    public List<Car>findAll() {
    	TypedQuery<Car> query = em.createNamedQuery("Car.findAll", Car.class);
    	List<Car> results = query.getResultList();
    	return results;
    }

}
