package com.coolcars.eao;

import java.util.List;

import javax.ejb.Local;

import com.coolcars.ejb.Car;

@Local
public interface CarEAOLocal {
	public Car findByLicenseNbr(String licenseNbr);
	public Car createCar(Car car);
	public Car updateCar(Car car);
	public void deleteCar(String licenseNbr);
	public List<Car> findAll();

}
