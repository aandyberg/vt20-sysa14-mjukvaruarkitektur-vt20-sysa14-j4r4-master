package com.coolcars.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.coolcars.ejb.Car;
import com.coolcars.ejb.Person;

/**
 * Session Bean implementation class PersonEAOImpl
 */
@Stateless
public class PersonEAOImpl implements PersonEAOLocal {

    @PersistenceContext(unitName="CoolCarsEJBSql")
    private EntityManager em;
    
    public PersonEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Person findByPersonPId(String pId) {
    	return em.find(Person.class, pId);
    }
    public Person createPerson(Person person) {
    	em.persist(person);
    	return person;
    }
    public Person updatePerson(Person person) {
    	em.merge(person);
    	return person;
    }
    public void deletePerson(String pId) {
    	Person p = this.findByPersonPId(pId);
    	if (p != null) {
    		em.remove(p);
    	}
    }
    public List<Person>findAllPersons() {
    	TypedQuery<Person> query = em.createNamedQuery("Person.findAllPersons", Person.class);
    	List<Person> results = query.getResultList();
    	return results;
    }

}
