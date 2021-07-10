package com.coolcars.eao;

import java.util.List;

import javax.ejb.Local;

import com.coolcars.ejb.Person;

@Local
public interface PersonEAOLocal {
	public Person findByPersonPId(String pId);
	public Person createPerson(Person person);
	public Person updatePerson(Person person);
	public void deletePerson(String pId);
	public List<Person> findAllPersons();

}
