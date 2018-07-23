package com.evelynda1985.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evelynda1985.crm.entity.Customer;

@Repository //it is a DAO implementation 
public class CustomerDAOImpl implements CustomerDAO {

	//I need to inject the session factory
	
	@Autowired //Independecy injection for sessionFactory
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query sort it by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get the list result - of customers
		List<Customer> customers = theQuery.getResultList();

		//return the list of customers
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer saveorupdate is good for insert or update
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer updateCustomer(int theId) {
		
		//get the current hibernate sesseoin
		Session session = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate sesseoin
		Session session = sessionFactory.getCurrentSession();
		
		//delete the customer
		//they are two ways to delete a customer throug HQL
		
		/*Query<Customer> theQuery = session.createQuery("delete from Customer c where c.id =: customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();*/
		
		Customer theCustomer = session.get(Customer.class, theId);
		
		session.delete(theCustomer);
				
	}


}
